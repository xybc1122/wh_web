package com.wh.mapper.fba;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.fba.WhFbaStocking;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public interface WhFbaStockingMapper extends BaseMapper<WhFbaStocking> {


    @SelectProvider(type = WhFbaStockingProvider.class, method = "findQueryFbaList")
    List<WhFbaStocking> selFbaInfo(WhFbaStocking whFbaStocking);

}
