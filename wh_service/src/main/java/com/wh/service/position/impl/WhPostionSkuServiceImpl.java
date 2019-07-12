package com.wh.service.position.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.position.WhPostionSku;
import com.wh.mapper.position.WhPostionSkuMapper;
import com.wh.service.position.WhPostionSkuService;
import org.springframework.beans.factory.annotation.Autowired;

public class WhPostionSkuServiceImpl extends ServiceImpl<WhPostionSkuMapper, WhPostionSku> implements WhPostionSkuService {
    @Autowired
   // private WhProductSkuMapper whProductSkuMapper;
    private WhPostionSkuMapper whPostionSkuMapper;
    @Override
    public WhPostionSku selectInventoryBySku(String sku) {
        //return  whProductSkuMapper.selectProductSku(sku);
       // return whPostionSkuMapper.selectInventoryBySku(sku);
        return null;
    }
}
