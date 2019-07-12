package com.wh.service.position;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.position.WhPosition;
import org.springframework.stereotype.Service;

@Service
public interface WhPositionService extends IService<WhPosition> {
    /**
     * 根據sku查询仓位
     * @param asin
     * @return
     */
    WhPosition getBaseByProductId(String asin);

    /**
     * 根据仓位查询sku
     * @param optionName
     * @return
     */
    String selectAsinByOptionName(String optionName);
}
