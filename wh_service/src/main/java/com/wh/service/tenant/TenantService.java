package com.wh.service.tenant;

/**
 * @ClassName TenantService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/15 17:05
 * 11
 **/
public interface TenantService {

    /**
     * 切换数据源服务
     */
    void switchTenant(String tenant);


}
