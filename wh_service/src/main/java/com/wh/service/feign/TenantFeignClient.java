package com.wh.service.feign;

import com.wh.base.ResponseBase;
import com.wh.service.fallback.TenantClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName PhpFeignClient
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 10:33
 **/

//然后再自己控制器里面调用此接口就完成了
@FeignClient(name = "tenant-service",fallback = TenantClientFallback.class)
public interface TenantFeignClient {

    /**
     * 获得租户信息
     *
     * @return
     */
    @GetMapping(value = "/api/v1/tenant/tenantList")
    ResponseBase getTenantList();


}
