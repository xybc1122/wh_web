package com.wh.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com/wh/entity");
        return configurer;
    }

    /**
     * 多租户 //包含分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        /*
//         * 【测试多租户】 SQL 解析处理拦截器<br>
//         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
//         */
//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        TenantSqlParser tenantSqlParser = new TenantSqlParser();
//        tenantSqlParser.setTenantHandler(new TenantHandler() {
//            @Override
//            public Expression getTenantId() {
//                return new LongValue(1L);
//            }
//
//            @Override
//            public String getTenantIdColumn() {
//                return "tenant_id";
//            }
//
//            @Override
//            public boolean doTableFilter(String tableName) {
//                // 这里可以判断是否过滤表
//            /*
//            if ("com".equals(tableName)) {
//                return true;
//            }*/
//                return false;
//            }
//        });
//        sqlParserList.add(tenantSqlParser);
//        paginationInterceptor.setSqlParserList(sqlParserList);
//        paginationInterceptor.setSqlParserFilter(metaObject -> {
//            MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
//            // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
//            if ("com.mq.demo.dao.SystemUserUploadMapper.insert".equals(ms.getId())) {
//                return true;
//            }
//            return false;
//        });
        return paginationInterceptor;
    }
}
