package com.wh.mapper.product;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.product.WhProduct;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhProductMapper extends BaseMapper<WhProduct> {

    //@SelectProvider(type = WhProductProvider.class,method = "selectProductItem")
  /*  @Select("(select  n from wh_product where name_cn=#{name}) as p left join wh_product_sku w on p")
    List<ProductDto> selProductPage(Page<ProductDto> dtoPage,String name,String type);*/

    /**
     * 根据sku查询产品
     * @param sku
     * @return
     */
    @Select("select p.* from ((select spu_asin from wh_product_sku where asin=#{sku}) s inner join  wh_product p on s.spu_asin=p.asin)")
    @Results(id="productMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "pic_json",property = "picJson"),
            @Result(column = "weight",property = "weight"),
            @Result(column = "is_new",property = "isNew"),
            @Result(column = "supplier_id",property = "supplierId"),
            @Result(column = "good_status",property = "goodStatus"),
            @Result(column = "purchase_user",property = "purchaseUser"),
            @Result(column = "name_cn",property = "nameCn"),
            @Result(column = "asin",property = "asin"),
            @Result(column = "price_purchase",property = "pricePurchase")
    })
    List<WhProduct> selectProductByOption(String sku);

    /**
     * 根据名称查询产品
     * @param name
     * @return
     */
    @ResultMap("productMap")
    @Select("select id,pic_json,weight,is_new,supplier_id,good_status,purchase_user,name_cn,asin,price_purchase from wh_product where name_cn like CONCAT('%',#{name},'%')")
    List<WhProduct> selectProductByName(String name);

    /**
     * 根据采购员查询产品
     * @param purchaser
     * @return
     */
    @Select("select id,pic_json,weight,is_new,supplier_id,good_status,purchase_user,name_cn,asin,price_purchase from wh_product where purchase_user  like CONCAT('%',#{purchaser},'%')")
    @ResultMap("productMap")
    List<WhProduct> selectProductByPurchaser(String purchaser);

}
