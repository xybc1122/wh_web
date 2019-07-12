package com.wh.init;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wh.base.ApplicationContextRegister;
import com.wh.base.ResponseBase;
import com.wh.dds.DynamicDataSource;
import com.wh.service.feign.TenantFeignClient;
import com.wh.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName com.wh.init.InitTargetDataSources
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/12 14:36
 **/
@Component
@Order(0)
public class InitTargetDataSources implements CommandLineRunner {


    @Autowired
    private TenantFeignClient feignClient;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    private static InitTargetDataSources targetDataSources;
    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {

        targetDataSources = this;
    }

    //通过@PostConstruct实现初始化bean之前进行的操作


    @Override
    public void run(String... args) {
        ResponseBase tenantList = feignClient.getTenantList();
        JSONArray jsonList = JsonUtils.getJsonArr(tenantList.getData());
        Map<Object, Object> dataSourceMap = new HashMap<>();
        for (Object obj : jsonList) {
            JSONObject t = JSONObject.parseObject(JsonUtils.getJsonObj(obj));
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://%s/%s?useUnicode=true&nullCatalogMeansCurrent=true&characterEncoding=utf-8&useSSL=false";
            druidDataSource.setUrl(String.format(URL, t.get("dbIp"), t.get("dbDatabase")));
            druidDataSource.setUsername(t.get("dbName").toString());
            druidDataSource.setPassword(t.get("dbPwd").toString());
            druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
            dataSourceMap.put(t.get("tenant"), druidDataSource);

        }
        targetDataSources.dynamicDataSource.setDataSources(dataSourceMap);
        targetDataSources.dynamicDataSource.afterPropertiesSet();
        System.out.println(dataSourceMap);
    }

}
