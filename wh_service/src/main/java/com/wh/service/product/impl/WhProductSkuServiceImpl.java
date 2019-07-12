package com.wh.service.product.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.product.WhProductSku;
import com.wh.mapper.product.WhProductSkuMapper;
import com.wh.service.product.IWhProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhProductSkuServiceImpl extends ServiceImpl<WhProductSkuMapper, WhProductSku> implements IWhProductSkuService {

    @Autowired
    private WhProductSkuMapper whProductSkuMapper;
    @Override
    public WhProductSku selectProductSku(String asin) {
        WhProductSku productSku=whProductSkuMapper.selectProductSku(asin);
        return productSku;
    }
}
