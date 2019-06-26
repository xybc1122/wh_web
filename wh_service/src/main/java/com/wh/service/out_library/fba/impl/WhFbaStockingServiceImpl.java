package com.wh.service.out_library.fba.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.out_library.fba.WhFbaStocking;
import com.wh.entity.out_library.fba.entry.WhFbaStockingEntry;
import com.wh.mapper.out_library.fba.WhFbaStockingMapper;
import com.wh.service.out_library.fba.IWhFbaStockingEntryService;
import com.wh.service.out_library.fba.IWhFbaStockingService;
import com.wh.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ResponseBase serviceSelListWhFbaStocking(WhFbaStocking whFbaStocking) {
        PageInfoUtils.setPage(whFbaStocking.getPageSize(), whFbaStocking.getCurrentPage());
        //1查询fba表体
        List<WhFbaStocking> whFbaStockings = stockingMapper.selFbaInfo(whFbaStocking);
        // 2 判断是否 有数据
        if (!ListUtils.isList(whFbaStockings)) {
            return PageInfoUtils.returnPage(whFbaStockings);
        }
        List<Long> fidList = new ArrayList<>();
        for (WhFbaStocking fba : whFbaStockings) {
            fidList.add(fba.getId());
        }

        //3 条目表 in 查询
        QueryWrapper<WhFbaStockingEntry> eQuery = WrapperUtils.getQuery();
        eQuery.in("fs_id", fidList).select(WhFbaStockingEntry.class,info-> ! info.getColumn().equals("remark"));
        List<WhFbaStockingEntry> stockingEntries = entryService.list(eQuery);

        //4继续判断 条目表是否有数据
        if (!ListUtils.isList(stockingEntries)) {
            return PageInfoUtils.returnPage(whFbaStockings);
        }
        //5设置属性 返回集合
        for (int i = 0; i < fidList.size(); i++) {
            List<WhFbaStockingEntry> listNe = new ArrayList<>();
            Long fid = fidList.get(i);
            for (WhFbaStockingEntry se : stockingEntries) {
                if (fid.equals(se.getFsId())) {
                    listNe.add(se);
                }
            }
            whFbaStockings.get(i).setEntry(listNe);
        }
        return PageInfoUtils.returnPage(whFbaStockings);
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
}
