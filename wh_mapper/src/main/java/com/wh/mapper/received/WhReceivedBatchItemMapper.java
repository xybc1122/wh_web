package com.wh.mapper.received;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.received.WhReceivedBatchItem;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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


}
