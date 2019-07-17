package com.wh.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.dto.ProductDetailDto;
import com.wh.entity.dto.ProductDetailEntityDto;
import com.wh.entity.received.WhReceived;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yyk
 * @date 2019/7/10 17:03
 * @description ${description}
 */

public interface WhProductDetailService extends IService<WhReceived> {
    /**
     *根据sku查询产品详情
     * @Return com.wh.base.ResponseBase
     * @Date 2019/7/9 12:51
     * @Param [type, sku]
     * @Author yyk
     */

    ProductDetailEntityDto findDetailBySku(int type, String sku);
}
