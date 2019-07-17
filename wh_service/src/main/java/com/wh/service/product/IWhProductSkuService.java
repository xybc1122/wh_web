package com.wh.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.product.WhProductSku;

import java.util.List;

public interface IWhProductSkuService extends IService<WhProductSku> {

    List<WhProductSku> selectProductSku(String asin);
}
