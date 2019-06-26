package com.wh.mapper.out_library.fba;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.out_library.fba.WhFbaStocking;
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

    /**
     * 查询fba信息
     *
     * @param whFbaStocking
     * @return
     */
    @SelectProvider(type = WhFbaStockingProvider.class, method = "findQueryFbaList")
    List<WhFbaStocking> selFbaInfo(WhFbaStocking whFbaStocking);

}
