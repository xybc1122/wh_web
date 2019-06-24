package com.wh.service.fba;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.fba.entry.WhFbaStockingEntry;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public interface IWhFbaStockingEntryService extends IService<WhFbaStockingEntry> {


    /**
     * 修改/删除 fba 箱号
     *
     * @param objectMap
     * @return
     */
    ResponseBase upOrWhFbaStockingEntry(Map<String, Object> objectMap);

}
