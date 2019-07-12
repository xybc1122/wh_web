package com.wh.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.product.WhProductSku;

public interface IWhProductSkuService extends IService<WhProductSku> {

    WhProductSku selectProductSku(String asin);
}
