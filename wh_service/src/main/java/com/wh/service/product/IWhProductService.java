package com.wh.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.ProductDto;
import com.wh.entity.product.WhProduct;

import java.util.List;

public interface IWhProductService extends IService<WhProduct> {
    /**
     *根据条件查询产品信息
     * @Date 2019/7/9 12:49
     * @Param [type, content]
     * @Author yyk
     * @Return com.wh.base.ResponseBase
     */

    List<ProductDto> selectProduct(String type, String content, int pageSize, int currentPage);

    /**
     *根据sku查询产品详情
     * @Return com.wh.base.ResponseBase
     * @Date 2019/7/9 12:51
     * @Param [type, sku]
     * @Author yyk
     */

   // List<ProductDetailDto> findDetailBySku(String type, String sku);
}
