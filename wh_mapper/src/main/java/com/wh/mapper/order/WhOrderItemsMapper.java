package com.wh.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.order.WhOrderItems;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yyk
 * @date 2019/7/11 14:50
 * @description 订单详情表
 */
@Repository
public interface WhOrderItemsMapper extends BaseMapper<WhOrderItems> {
    /**
     * 根据主订单id查找订单详情信息
     * @Param [id]
     * @Return java.util.List<com.wh.entity.order.WhOrderItems>
     * @Date 2019/7/11 15:24
     * @Author yyk
     */
    @Results(id = "orderItem",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "order_id",property = "orderId"),
            @Result(column = "item_price",property = "itemPrice")
    })
    @Select("select * from wh_order_items where order_id=#{id} and sku_asin=#{asin}")
    List<WhOrderItems> findOrderItemsByOrderId(@Param("id") int id, @Param("asin") String asin);

}
