package com.wh.service.feign;

import com.alibaba.fastjson.JSONObject;
import com.wh.base.ResponseBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName PhpFeignService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 10:33
 **/


//然后再自己控制器里面调用此接口就完成了
@FeignClient(name = "php", url = "http://192.168.1.232:85")
public interface PhpFeignService {

    /**
     * 调用php 接口验证是否还有sku库存
     *
     * @return
     */
    @GetMapping(value = "/api/base/position/asin/stock", consumes = "application/json;charset=UTF-8")
    ResponseBase checkAsinQ(@RequestParam("asin") String sku, @RequestParam("wh_id") Integer whId);

    /**
     * 调用php 新增调拨入库
     *
     * @return
     */
    @PostMapping(value = "/api/received/requisition", consumes = "application/json;charset=UTF-8")
    ResponseBase setPhpTransferOutLibrary(@RequestBody Map<String, Object> params);

}
