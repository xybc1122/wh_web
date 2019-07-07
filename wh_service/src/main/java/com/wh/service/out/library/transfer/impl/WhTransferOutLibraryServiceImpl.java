package com.wh.service.out.library.transfer.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.TransferDto;
import com.wh.entity.out.library.transfer.WhTransferOutLibrary;
import com.wh.entity.out.library.transfer.entry.WhTransferOutLibraryEntry;
import com.wh.exception.LsException;
import com.wh.mapper.out.library.transfer.WhTransferOutLibraryMapper;
import com.wh.service.feign.PhpFeignClient;
import com.wh.service.out.library.transfer.IWhTransferOutLibraryEntryService;
import com.wh.service.out.library.transfer.IWhTransferOutLibraryService;
import com.wh.service.redis.RedisService;
import com.wh.store.BindingResultStore;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.*;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.*;

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
    private RedisService redisService;

    @Autowired
    private PhpFeignClient feignService;

    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public List<WhTransferOutLibrary> serviceSelOutLibraryInfo(WhTransferOutLibrary outLibrary) {
        PageInfoUtils.setPage(outLibrary.getPageSize(), outLibrary.getCurrentPage());
        //1查询调拨出库表体
        List<WhTransferOutLibrary> outLibraryList = outLibraryMapper.selOutLibraryInfo(outLibrary);

        // 2判断是否有数据
        if (!CollectionUtils.isList(outLibraryList)) {
            return outLibraryList;
        }

        //获得in查询集合
        List<String> tNumberList = new ArrayList<>();
        for (WhTransferOutLibrary ol : outLibraryList) {
            tNumberList.add(ol.gettNumber());
        }


        //3 条目表 in 查询
        QueryWrapper<WhTransferOutLibraryEntry> eQuery = WrapperUtils.getQuery();
        eQuery.in("t_number", tNumberList).select(WhTransferOutLibraryEntry.class, info -> !info.getColumn().equals("remark"));
        List<WhTransferOutLibraryEntry> outLibraryEntries = outLibraryEntryService.list(eQuery);


        //4继续判断 条目表是否有数据
        if (!CollectionUtils.isList(outLibraryEntries)) {
            return outLibraryList;
        }


        //5设置属性 返回集合
        for (int i = 0; i < tNumberList.size(); i++) {
            List<WhTransferOutLibraryEntry> listNe = new ArrayList<>();
            String tNumber = tNumberList.get(i);
            for (WhTransferOutLibraryEntry e : outLibraryEntries) {
                if (tNumber.equals(e.gettNumber())) {
                    listNe.add(e);
                }
            }
            outLibraryList.get(i).setEntry(listNe);
        }
        return outLibraryList;
    }

    @Override
    public ResponseBase serviceDelOutLibraryInfo(Map<String, Object> objectMap) {
        //1 是否全部删除
        String tNumber = (String) objectMap.get("tNumber");
        if (StringUtils.isBlank(tNumber)) {
            return JsonData.setResultError("单号 is null");
        }
        List eIds = (List) objectMap.get("eIds");
        String identifier = null;
        try {
            identifier = redisService.lockRedis(tNumber, Constants.maxWait, Constants.timeout);

            //1先查询我的订单状态 如果正在执行流程中 不给更新状态
            Integer executionStatus = outLibraryMapper.selExecutionStatus(tNumber);
            if (executionStatus == null) {
                //如果==null 说明没有此单号
                return JsonData.setResultError("没有此单号");
            }
            if (executionStatus == 1) {
                //如果==1 说明已经在执行流程
                return JsonData.setResultError("此单正在流程执行中,不能修改状态");
            }

            QueryWrapper<WhTransferOutLibraryEntry> eQuery;
            //如果 子id 不是null 或者 长度是0  就代表删除子表数据
            if (eIds != null && eIds.size() > 0) {
                eQuery = WrapperUtils.getQuery();
                eQuery.in("id", eIds);
                //就是只单独删除子节点
                CheckUtils.saveResult(outLibraryEntryService.remove(eQuery));
            } else {
                QueryWrapper<WhTransferOutLibrary> tQuery = WrapperUtils.getQuery();
                tQuery.eq("t_number", tNumber);
                //否则就全删除 先删除父节点
                CheckUtils.saveResult(outLibraryMapper.delete(tQuery));
                //在删除子节点
                eQuery = WrapperUtils.getQuery();
                eQuery.eq("t_number", tNumber);
                CheckUtils.saveResult(outLibraryEntryService.remove(eQuery));
            }
            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(tNumber, identifier);
            }
        }
    }

    @Override
    @Transactional
    public ResponseBase serviceUpOutLibraryStatus(WhTransferOutLibrary outLibrary) {
        if (StringUtils.isBlank(outLibrary.gettNumber()) || outLibrary.getVersion() == null) {
            return JsonData.setResultError("参数 is null");
        }
        String identifier = null;
        try {
            identifier = redisService.lockRedis(outLibrary.gettNumber(), Constants.maxWait, Constants.timeout);

            //1先查询我的订单状态 如果正在执行流程中 不给更新状态
            Integer executionStatus = outLibraryMapper.selExecutionStatus(outLibrary.gettNumber());
            if (executionStatus == null) {
                //如果==null 说明没有此单号
                return JsonData.setResultError("没有此单号");
            }
            if (executionStatus == 1) {
                //如果==1 说明已经在执行流程
                return JsonData.setResultError("此单正在流程执行中,不能修改状态");
            }
            UpdateWrapper<WhTransferOutLibrary> upWrapper = new UpdateWrapper<>();
            final Integer version = outLibrary.getVersion();

            upWrapper.set("status", 1).set("modify_user", ReqUtils.getUserName()).
                    set("modify_date", new Date().getTime()).set("version", version + 1).set("execution_status", 1);
            upWrapper.eq("t_number", outLibrary.gettNumber()).eq("version", version);
            CheckUtils.saveResult(this.update(null, upWrapper));

            //2 拿到订单号去查询 对象数据
            List<WhTransferOutLibrary> whTransferOutLibraries = serviceSelOutLibraryInfo(new WhTransferOutLibrary(outLibrary.gettNumber()));

            //深度拷贝 转换成dto 传输
            TransferDto transferDto = mapperFacade.map(whTransferOutLibraries.get(0), TransferDto.class);
            //这里会有分布式事物

            //p1 调用php 接口
            ResponseBase phpBase = feignService.setPhpTransferOutLibrary(EntityUtils.entityToMap(transferDto));
            if (phpBase.getCode() != 200) {
                throw new LsException(phpBase.getMsg());
            }
            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(outLibrary.gettNumber(), identifier);
            }
        }

    }

    @Override
    @Transactional
    public ResponseBase serviceSaveOutLibraryInfo(WhTransferOutLibrary outLibrary, BindingResult bindingResult) {
        //校验参数
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);

        List<WhTransferOutLibraryEntry> entryList = outLibrary.getEntry();
        // P1 先调用php 接口查询一下库存是否充足
        for (WhTransferOutLibraryEntry e : entryList) {
            ResponseBase base = feignService.checkAsinQ(e.getSku(), outLibrary.getrWarId());
            //如果是-1 说明没找到
            if (base.getCode() == -1) {
                return JsonData.setResultError(base.getMsg());
            }
            //如果不是 校验下 数目
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(base.getData()));

            if (!(jsonObject.containsKey("stock"))) {
                //如果没有
                return JsonData.setResultError("stock is null");
            }

            if (!(jsonObject.get("stock") instanceof String)) {
                return JsonData.setResultError("stock 类型 转换异常 期待的是String ");
            }

            String stock = (String) jsonObject.get("stock");
            //这里判断 是否有足够的库存转出
            if (e.getQuantity() > Integer.parseInt(stock)) {
                return JsonData.setResultError(e.getSku() + "的数量不足,操作数量:" + e.getQuantity() + "库存数量:" + stock);
            }
        }

        //1新增调拨主表
        outLibrary.settNumber(StaticVariable.DB + snowflakeUtils.nextId());
        outLibrary.setCreate(ReqUtils.getUserName());
        CheckUtils.saveResult(this.save(outLibrary));

        //2新增sku条目表
        for (WhTransferOutLibraryEntry e : entryList) {
            e.setId(StaticVariable.DB_E_ID + snowflakeUtils.nextId());
            e.setCreate(ReqUtils.getUserName());
            e.settNumber(outLibrary.gettNumber());
        }
        CheckUtils.saveResult(outLibraryEntryService.saveBatch(entryList));

        return JsonData.setResultSuccess("success");
    }

}
