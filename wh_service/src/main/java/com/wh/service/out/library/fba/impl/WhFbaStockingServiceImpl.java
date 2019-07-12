package com.wh.service.out.library.fba.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.box.Box;
import com.wh.entity.out.library.fba.WhFbaStocking;
import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;
import com.wh.mapper.out.library.fba.WhFbaStockingMapper;
import com.wh.service.out.library.fba.IWhFbaStockingEntryService;
import com.wh.service.out.library.fba.IWhFbaStockingService;
import com.wh.store.BindingResultStore;
import com.wh.toos.StaticVariable;
import com.wh.utils.*;
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
 * @since 2019-06-21
 */
@Service
public class WhFbaStockingServiceImpl extends ServiceImpl<WhFbaStockingMapper, WhFbaStocking> implements IWhFbaStockingService {

    @Autowired
    private WhFbaStockingMapper stockingMapper;

    @Autowired
    private IWhFbaStockingEntryService entryService;

    @Autowired
    private SnowflakeUtils snowflakeUtils;


    @Override
    public List<WhFbaStocking> serviceSelListWhFbaStocking(WhFbaStocking whFbaStocking) {
        PageInfoUtils.setPage(whFbaStocking.getPageSize(), whFbaStocking.getCurrentPage());
        //1查询fba表体
        List<WhFbaStocking> whFbaStockings = stockingMapper.selFbaInfo(whFbaStocking);

        // 2 判断是否 有数据
        if (!CollectionUtils.isList(whFbaStockings)) {
            return whFbaStockings;
        }

        List<String> fidList = new ArrayList<>();
        for (WhFbaStocking fba : whFbaStockings) {
            fidList.add(fba.getSingleNumber());
        }

        //3 条目表 in 查询
        QueryWrapper<WhFbaStockingEntry> eQuery = WrapperUtils.getQuery();
        eQuery.in("s_n", fidList).select(WhFbaStockingEntry.class, info -> !info.getColumn().equals("remark"));
        List<WhFbaStockingEntry> stockingEntries = entryService.list(eQuery);

        //4继续判断 条目表是否有数据
        if (!CollectionUtils.isList(stockingEntries)) {
            return whFbaStockings;
        }
        //这里拼接  成箱号集合
        List<Box> boxList = new ArrayList<>();
        for (WhFbaStockingEntry sEntry : stockingEntries) {
            if (StringUtils.isNotBlank(sEntry.getTrackingNumber())) {
                boxList.add(new Box(sEntry.getTrackingNumber(), sEntry.getSpecification(), sEntry.getSn()));
            }
        }
        // 继续判断 箱号是否有数据
        if (!CollectionUtils.isList(boxList)) {
            return whFbaStockings;
        }

        //TODO 这里去重   这里后期都要封装掉
        Map<String, Box> map = new HashMap<>();
        for (Box box : boxList) {
            map.put(box.getTrackingNumber(), box);
        }
        boxList.clear();
        boxList.addAll(map.values());


        //5设置 箱号跟sku列表数据 返回集合
        for (Box b : boxList) {
            List<WhFbaStockingEntry> listNe = new ArrayList<>();
            for (WhFbaStockingEntry se : stockingEntries) {
                if (b.getSn().equals(se.getSn()) && b.getTrackingNumber().equals(se.getTrackingNumber())) {
                    listNe.add(se);
                }
            }
            b.setEntry(listNe);
        }
        //6 返回最终集合
        for (int i = 0; i < fidList.size(); i++) {
            List<Box> newBox = new ArrayList<>();
            for (Box b : boxList) {
                if (fidList.get(i).equals(b.getSn())) {
                    newBox.add(b);
                }
            }
            whFbaStockings.get(i).setBoxes(newBox);
        }

        return whFbaStockings;
    }


    @Override
    public ResponseBase serviceUpWhFbaStocking(WhFbaStocking whFbaStocking) {
        Integer version = whFbaStocking.getVersion();
        whFbaStocking.setModify(ReqUtils.getUserName(), version);

        UpdateWrapper<WhFbaStocking> upWrapper = new UpdateWrapper<>();
        upWrapper.eq("id", whFbaStocking.getId()).eq("version", version);

        CheckUtils.saveResult(this.update(whFbaStocking, upWrapper));
        return JsonData.setResultSuccess("success");
    }

    @Override
    @Transactional
    public ResponseBase serviceSaveWhFbaStocking(WhFbaStocking whFbaStocking, BindingResult bindingResult) {
        //校验参数
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);
        saveWhFbaStocking(whFbaStocking);

        return JsonData.setResultSuccess("success");
    }


    @Override
    @Transactional
    public boolean serviceXlsSaveWhFbaStocking(List<WhFbaStocking> whFbaStockings) {
        for (WhFbaStocking whFbaStocking : whFbaStockings) {
            saveWhFbaStocking(whFbaStocking);
        }
        return true;
    }


    private void saveWhFbaStocking(WhFbaStocking whFbaStocking) {
        //1新增FBA主表
        whFbaStocking.setSingleNumber(StaticVariable.FBA + snowflakeUtils.nextId());
        whFbaStocking.setCreate(ReqUtils.getUserName());
        CheckUtils.saveResult(this.save(whFbaStocking));
        //2 新增 FBA箱号
        List<WhFbaStockingEntry> entryList = whFbaStocking.getEntry();
        for (WhFbaStockingEntry e : entryList) {
            e.setId(StaticVariable.FBA_E_ID + snowflakeUtils.nextId());
            e.setCreate(ReqUtils.getUserName());
            e.setSn(whFbaStocking.getSingleNumber());
        }
        CheckUtils.saveResult(entryService.saveBatch(entryList));
    }

}
