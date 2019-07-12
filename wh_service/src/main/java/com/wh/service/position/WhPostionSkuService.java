package com.wh.service.position;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.position.WhPostionSku;
import org.springframework.stereotype.Service;

@Service
public interface WhPostionSkuService extends IService<WhPostionSku> {
    /**
     * 根据sku查询实际库存和配货库存
     * @param sku
     * @return
     */
    WhPostionSku selectInventoryBySku(String sku);
}
