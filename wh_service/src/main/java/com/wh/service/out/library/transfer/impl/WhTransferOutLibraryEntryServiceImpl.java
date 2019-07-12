package com.wh.service.out.library.transfer.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.out.library.transfer.entry.WhTransferOutLibraryEntry;
import com.wh.mapper.out.library.transfer.WhTransferOutLibraryEntryMapper;
import com.wh.mapper.out.library.transfer.WhTransferOutLibraryMapper;
import com.wh.service.feign.PhpFeignClient;
import com.wh.service.out.library.transfer.IWhTransferOutLibraryEntryService;
import com.wh.service.redis.RedisService;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class WhTransferOutLibraryEntryServiceImpl extends ServiceImpl<WhTransferOutLibraryEntryMapper, WhTransferOutLibraryEntry>
        implements IWhTransferOutLibraryEntryService {
    @Autowired
    private SnowflakeUtils snowflakeUtils;

    @Autowired
    private RedisService redisService;

    @Autowired
    private WhTransferOutLibraryServiceImpl outLibraryImpl;

    @Override
    @Transactional
    public ResponseBase serviceUpOutLibrary(Map<String, Object> objectMap) {
        //1 是否全部删除
        String tNumber = (String) objectMap.get("tNumber");
        if (StringUtils.isBlank(tNumber)) {
            return JsonData.setResultError("单号 is null");
        }
        String identifier = null;
        try {

            identifier = redisService.lockRedis(tNumber, Constants.maxWait, Constants.timeout);

            //校验
            outLibraryImpl.cheNumber(tNumber);

            //1先获得要删除的 子表id
            Object delIds = objectMap.get("delIds");
            if (delIds instanceof List) {
                List dList = (List) delIds;
                //判断是否长度为0
                if (CollectionUtils.isList(dList)) {
                    QueryWrapper<WhTransferOutLibraryEntry> enQuery = WrapperUtils.getQuery();
                    enQuery.in("id", dList);
                    CheckUtils.saveResult(this.remove(enQuery));
                }
            }

            //2获得想要更新的 箱号对象
            Object libraryEntry = objectMap.get("libraryEntry");
            if (libraryEntry instanceof List) {
                //拿到调拨单表体数据
                JSONArray JSONArr = JsonUtils.getJsonArr(libraryEntry);
                for (Object obj : JSONArr) {
                    //转换成对象 设置修改时间
                    WhTransferOutLibraryEntry entry = (WhTransferOutLibraryEntry) JsonUtils.objConversion(obj, WhTransferOutLibraryEntry.class);

                    String cheResult = outLibraryImpl.cheSkuQuantity(entry.getQuantity(), entry.getSku());
                    if (cheResult != null) {
                        return JsonData.setResultError(cheResult);
                    }
                    Integer version = entry.getVersion();
                    entry.setModify(ReqUtils.getUserName(), version);
                    entry.settNumber(tNumber);
                    if (entry.getId() != null) {
                        // 更新
                        UpdateWrapper<WhTransferOutLibraryEntry> upWrapper = new UpdateWrapper<>();
                        upWrapper.eq("id", entry.getId()).eq("version", version);
                        CheckUtils.saveResult(this.update(entry, upWrapper));
                    } else {
                        //新增
                        entry.setId(StaticVariable.DB_E_ID + snowflakeUtils.nextId());
                        CheckUtils.saveResult(this.save(entry));
                    }
                }
            }
            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(tNumber, identifier);
            }
        }
    }
}
