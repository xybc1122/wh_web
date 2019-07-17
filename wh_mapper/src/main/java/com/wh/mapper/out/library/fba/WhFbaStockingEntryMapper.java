package com.wh.mapper.out.library.fba;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public interface WhFbaStockingEntryMapper extends BaseMapper<WhFbaStockingEntry> {
    @Select("select * from wh_fba_stocking_entry where sku=#{sku}")
    List<WhFbaStockingEntry> selectFbaStockingEntryBySku(String sku);

}
