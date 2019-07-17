package com.wh.mapper.received;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.received.WhReceivedBatchItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhReceivedBatchItemMapper extends BaseMapper<WhReceivedBatchItem> {

    /**
     * 根据asin查询上架数量
     * @param asin
     * @return
     */
    @Results(id="receivedMap" ,value = {
            @Result(column = "id",property = "id"),
            @Result(column = "asin",property = "asin"),
            @Result(column = "status",property = "status"),
            @Result(column = "stock_number",property = "stockNumber")
    })
    @Select("select asin,status,stock_number from wh_received_batch_item where asin=#{asin}")
    List<WhReceivedBatchItem> selectStockByAsin(String asin);

    /**
     * 通过asin和receivedId查询上架数量
     * @Param [asin, received_id]
     * @Return java.util.List<com.wh.entity.received.WhReceivedBatchItem>
     * @Date 2019/7/10 17:40
     * @Author yyk
     */

    @ResultMap("receivedMap")
    @Select("select id,asin,status,stock_number from wh_received_batch_item where asin=#{asin} and received_id=#{received_id}")
    List<WhReceivedBatchItem> selectStockNumberBySkuAndReceivedId(@Param("asin") String asin, @Param("received_id") int received_id);

    @ResultMap("receivedMap")
    @Select("select id,asin,status,stock_number from wh_received_batch_item where id=#{id}")
    WhReceivedBatchItem selectReceivedBatchItemById(int id);
}
