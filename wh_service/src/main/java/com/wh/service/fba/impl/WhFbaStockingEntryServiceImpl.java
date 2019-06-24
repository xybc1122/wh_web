package com.wh.service.fba.impl;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.fba.WhFbaStocking;
import com.wh.entity.fba.entry.WhFbaStockingEntry;
import com.wh.mapper.fba.WhFbaStockingEntryMapper;
import com.wh.service.fba.IWhFbaStockingEntryService;
import com.wh.utils.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
@Service
public class WhFbaStockingEntryServiceImpl extends ServiceImpl<WhFbaStockingEntryMapper, WhFbaStockingEntry> implements IWhFbaStockingEntryService {


    @Override
    @Transactional
    public ResponseBase upOrWhFbaStockingEntry(Map<String, Object> objectMap) {
        //1先获得要删除的 箱号id
        Object delIds = objectMap.get("delIds");
        if (delIds instanceof List) {
            List dList = (List) delIds;
            //判断是否长度为0
            if (ListUtils.isList(dList)) {
                QueryWrapper<WhFbaStockingEntry> enQuery = WrapperUtils.getQuery();
                enQuery.in("id", dList);
                CheckUtils.saveResult(this.remove(enQuery));
            }
        }
        //2获得想要更新的 箱号id
        Object stockingEntry = objectMap.get("stockingEntry");
        if (stockingEntry instanceof List) {
            //拿到出库通知单的表体数据
            JSONArray JSONArr = JsonUtils.getJsonArr(stockingEntry);
            for (Object obj : JSONArr) {
                //转换成对象 设置修改时间
                WhFbaStockingEntry entry = (WhFbaStockingEntry) JsonUtils.objConversion(obj, WhFbaStockingEntry.class);
                Integer version = entry.getVersion();
                entry.setModify(ReqUtils.getUserName(), version);
                // 循环更新数据库
                UpdateWrapper<WhFbaStockingEntry> upWrapper = new UpdateWrapper<>();
                upWrapper.eq("id", entry.getId()).eq("version", version);
                CheckUtils.saveResult(this.update(entry, upWrapper));
            }
        }
        return JsonData.setResultSuccess("success");
    }


}
