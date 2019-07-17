package com.wh.mapper.product;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.product.WhProductSku;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhProductSkuMapper extends BaseMapper<WhProductSku>{

    @Results(id = "productSku",value = {
            @Result(column = "sku_info",property = "skuInfo"),
            @Result(column = "asin",property = "asin"),
            @Result(column = "spu_asin",property = "spu_asin")
    })
    @Select("select spu_asin,sku_info,asin from wh_product_sku where spu_asin=#{asin}")
    List<WhProductSku> selectProductSku(String asin);
}
