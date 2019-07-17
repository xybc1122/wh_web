package com.wh.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.order.WhOrderMain;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yyk
 * @date 2019/7/11 14:49
 * @description 主订单表
 */
@Repository
public interface WhOrderMainMapper extends BaseMapper<WhOrderMain> {

    /**
     * 根据sku查找出库信息
     * @Param [sku]
     * @Return java.util.List<com.wh.entity.order.WhOrderMain>
     * @Date 2019/7/11 15:14
     * @Author yyk
     */
    @Results(id = "orderMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "record_num",property = "recordNum"),
            @Result(column = "checkout_at",property = "checkoutAt"),
            @Result(column = "pack_uid",property = "packUid")
    })
    @Select("select id,record_num,checkout_at,pack_uid from wh_order_main where id in(select order_id from wh_order_items where sku_asin=#{sku}) and is_audit=1")
    List<WhOrderMain> selectOutStockBySku(String sku);

}
