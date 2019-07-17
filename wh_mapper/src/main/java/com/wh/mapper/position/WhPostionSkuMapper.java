package com.wh.mapper.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.position.WhPostionSku;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhPostionSkuMapper extends BaseMapper<WhPostionSku> {

    /**
     * 根据sku查询实际库存和配货库存
     * @param sku
     * @return
     */
    @Results(id = "postionSkuMapper",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "asin",column = "asin"),
            @Result(property = "stock",column = "stock"),
            @Result(property = "scanStock",column = "scan_stock"),
            @Result(property = "batchNo",column = "batch_no"),
            @Result(property = "batchItemId",column = "batch_item_id")
    })
    @Select("select id,asin,stock,scan_stock,batch_no,batch_item_id from wh_position_sku where asin=#{sku}")
    List<WhPostionSku> selectInventoryBySku(String sku);
}
