package com.wh.service.feign;

import com.wh.base.ResponseBase;
import com.wh.service.fallback.PhpClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName PhpFeignClient
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 10:33
 **/


//然后再自己控制器里面调用此接口就完成了
@FeignClient(name = "php", url = "http://192.168.1.232:85", fallback = PhpClientFallback.class)
public interface PhpFeignClient {

    /**
     * 调用php 接口验证是否还有sku库存
     *
     * @return
     */
    @GetMapping(value = "/api/base/position/asin/stock")
    ResponseBase checkAsinQ(@RequestParam("asin") String sku, @RequestParam("wh_id") Integer whId);

    /**
     * 调用php 新增调拨入库
     *
     * @return
     */
    @PostMapping(value = "/api/received/requisition")
    ResponseBase setPhpTransferOutLibrary(@RequestBody Map<String, Object> params);




}
