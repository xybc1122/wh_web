package com.wh.service.init;

import com.alibaba.druid.pool.DruidDataSource;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.dds.DynamicDataSource;
import com.wh.base.ApplicationContextRegister;
import com.wh.entity.tenant.WhWarehouseTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName InitTargetDataSources
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/12 14:36
 **/
@Component
@Order(2)
public class InitTargetDataSources implements CommandLineRunner {
    

    @Autowired
    private IWhWarehouseTenantService tenantService;


    @Override
    public void run(String... args) {
        System.out.println("测试");
        List<WhWarehouseTenant> tenantList = tenantService.list();
        DynamicDataSource dynamicDataSource = ApplicationContextRegister.getBean(DynamicDataSource.class);
        Map<Object, Object> dataSourceMap = tenantList.stream().collect(Collectors.toMap(
                WhWarehouseTenant::getTenant, tenant -> {
                    DruidDataSource druidDataSource = new DruidDataSource();
                    druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                    druidDataSource.setUrl(tenant.getDbUrl());
                    druidDataSource.setUsername(tenant.getDbName());
                    druidDataSource.setPassword(tenant.getDbPwd());
                    druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
                    return druidDataSource;
                }
        ));
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.afterPropertiesSet();
        System.out.println(dynamicDataSource);
    }
}
