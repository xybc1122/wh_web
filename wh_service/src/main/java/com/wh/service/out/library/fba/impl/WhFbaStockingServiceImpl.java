package com.wh.service.out.library.fba.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.FbaStockingDto;
import com.wh.entity.dto.FbaStockingEntryDto;
import com.wh.entity.out.library.fba.WhFbaStocking;
import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;
import com.wh.mapper.out.library.fba.WhFbaStockingMapper;
import com.wh.service.out.library.fba.IWhFbaStockingEntryService;
import com.wh.service.out.library.fba.IWhFbaStockingService;
import com.wh.store.BindingResultStore;
import com.wh.toos.StaticVariable;
import com.wh.utils.*;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

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
        if (!ListUtils.isList(whFbaStockings)) {
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
        if (!ListUtils.isList(stockingEntries)) {
            return whFbaStockings;
        }
        //5设置属性 返回集合
        for (int i = 0; i < fidList.size(); i++) {
            List<WhFbaStockingEntry> listNe = new ArrayList<>();
            String nid = fidList.get(i);
            for (WhFbaStockingEntry se : stockingEntries) {
                if (nid.equals(se.getSn())) {
                    listNe.add(se);
                }
            }
            whFbaStockings.get(i).setEntry(listNe);
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
