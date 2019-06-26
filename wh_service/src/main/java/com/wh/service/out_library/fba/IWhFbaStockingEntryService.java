package com.wh.service.out_library.fba;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.out_library.fba.entry.WhFbaStockingEntry;

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
