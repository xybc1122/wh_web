package com.wh.service.out_library.transfer.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.RedisLock;
import com.wh.entity.out_library.fba.WhFbaStocking;
import com.wh.entity.out_library.transfer.WhTransferOutLibrary;
import com.wh.entity.out_library.transfer.entry.WhTransferOutLibraryEntry;
import com.wh.mapper.out_library.transfer.WhTransferOutLibraryMapper;
import com.wh.service.out_library.transfer.IWhTransferOutLibraryEntryService;
import com.wh.service.out_library.transfer.IWhTransferOutLibraryService;
import com.wh.toos.Constants;
import com.wh.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
@Service
public class WhTransferOutLibraryServiceImpl extends ServiceImpl<WhTransferOutLibraryMapper, WhTransferOutLibrary> implements IWhTransferOutLibraryService {

    @Autowired
    private SnowflakeUtils snowflakeUtils;
    @Autowired
    private WhTransferOutLibraryMapper outLibraryMapper;
    @Autowired
    private IWhTransferOutLibraryEntryService outLibraryEntryService;

    @Autowired
    private RedisUtils redisService;

    @Override
    public ResponseBase serviceSelOutLibraryInfo(WhTransferOutLibrary outLibrary) {
        PageInfoUtils.setPage(outLibrary.getPageSize(), outLibrary.getCurrentPage());
        //1查询调拨出库表体
        List<WhTransferOutLibrary> outLibraryList = outLibraryMapper.selOutLibraryInfo(outLibrary);

        // 2判断是否有数据
        if (!ListUtils.isList(outLibraryList)) {
            return PageInfoUtils.returnPage(outLibraryList);
        }

        //获得in查询集合
        List<Long> idList = ListUtils.setInList(outLibraryList);


        //3 条目表 in 查询
        QueryWrapper<WhTransferOutLibraryEntry> eQuery = WrapperUtils.getQuery();
        eQuery.in("t_id", idList).select(WhTransferOutLibraryEntry.class, info -> !info.getColumn().equals("remark"));
        List<WhTransferOutLibraryEntry> outLibraryEntries = outLibraryEntryService.list(eQuery);


        //4继续判断 条目表是否有数据
        if (!ListUtils.isList(outLibraryEntries)) {
            return PageInfoUtils.returnPage(outLibraryList);
        }


        //5设置属性 返回集合
        for (int i = 0; i < idList.size(); i++) {
            List<WhTransferOutLibraryEntry> listNe = new ArrayList<>();
            Long tid = idList.get(i);
            for (WhTransferOutLibraryEntry e : outLibraryEntries) {
                if (tid.equals(e.gettId())) {
                    listNe.add(e);
                }
            }
            outLibraryList.get(i).setEntry(listNe);
        }
        return PageInfoUtils.returnPage(outLibraryList);
    }

    @Override
    public ResponseBase serviceDelOutLibraryInfo(Map<String, Object> objectMap) {
        //这里还要调用别的服务接口删除 需要分布式事物


        //1 是否全部删除
        Integer tid = (Integer) objectMap.get("tid");
        List eIds = (List) objectMap.get("eIds");
        QueryWrapper<WhTransferOutLibraryEntry> eQuery;
        //如果 父id 不是null 子id 是null 或者 长度是0  就代表全部删除父子表
        if (null != tid && null == eIds || eIds.size() <= 0) {
            //先删除父节点
            CheckUtils.saveResult(outLibraryMapper.deleteById(tid));
            //在删除子节点
            eQuery = WrapperUtils.getQuery();
            eQuery.eq("t_id", tid);
            CheckUtils.saveResult(outLibraryEntryService.remove(eQuery));
        } else {
            eQuery = WrapperUtils.getQuery();
            eQuery.in("id", eIds);
            //就是只单独删除子节点
            CheckUtils.saveResult(outLibraryEntryService.remove(eQuery));
        }

        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase serviceUpOutLibraryStatus(WhTransferOutLibrary outLibrary) {
        //这里还要调用别的服务接口更新 需要分布式事物
        if (StringUtils.isBlank(outLibrary.gettNumber())) {
            return JsonData.setResultError("参数 is null");
        }
        String identifier = null;
        try {
            identifier = redisService.lockRedis(outLibrary.gettNumber(), Constants.maxWait, Constants.timeout);

            //1先查询我的订单状态 如果正在执行流程中 不给更新状态
            if (outLibraryMapper.selExecutionStatus(outLibrary.gettNumber()) == 1) {
                //如果==1 说明已经在执行流程
                return JsonData.setResultError("此单正在流程执行中,不能修改状态");
            }

            UpdateWrapper<WhTransferOutLibrary> upWrapper = new UpdateWrapper<>();
            final Integer version = outLibrary.getVersion();

            upWrapper.set("status", outLibrary.getStatus()).set("modify_user", ReqUtils.getUserName()).
                    set("modify_date", new Date().getTime()).set("version", version + 1).set("execution_status", 1);
            upWrapper.eq("t_number", outLibrary.gettNumber()).eq("version", version);
            CheckUtils.saveResult(this.update(null, upWrapper));

            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(outLibrary.gettNumber(), identifier);
            }
        }

    }

    @Override
    public ResponseBase serviceSaveOutLibraryInfo(WhTransferOutLibrary outLibrary) {
        //这里还要调用别的服务接口删除 需要分布式事物

        if (outLibrary == null) {
            return JsonData.setResultError("参数 is null");
        }
        //1新增调拨主表
        outLibrary.settNumber("DB" + snowflakeUtils.nextId());
        outLibrary.setCreate(ReqUtils.getUserName());
        CheckUtils.saveResult(this.save(outLibrary));

        //2新增sku条目表
        List<WhTransferOutLibraryEntry> entryList = outLibrary.getEntry();
        if (entryList != null && entryList.size() > 0) {
            for (WhTransferOutLibraryEntry e : entryList) {
                e.setCreate(ReqUtils.getUserName());
                e.settId(outLibrary.getId());
            }
            CheckUtils.saveResult(outLibraryEntryService.saveBatch(entryList));
        }
        //3 存入 php接口表
        return JsonData.setResultSuccess("success");
    }

}
