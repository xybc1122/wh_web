package com.wh.service.feign;

import com.wh.base.ResponseBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @ClassName PhpFeignService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 10:33
 **/


//然后再自己控制器里面调用此接口就完成了
@FeignClient(name = "procurement", url = "http://192.168.1.232:85")
public interface PhpFeignService {

    /**
     * 调用php 采购订单接口 新增调拨入库单
     *
     * @param objectMap
     * @return
     */
    //@PostMapping(value = "api/procurement/store", consumes = "application/json;charset=UTF-8")
    ResponseBase purchaseOrder(@RequestBody Map<String, Object> objectMap);


}
