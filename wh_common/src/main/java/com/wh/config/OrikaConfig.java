package com.wh.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName OrikaConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/10 16:28
 **/
@Configuration
public class OrikaConfig {

    @Bean
    MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        List<ClassMapBuilder> builders = new LinkedList<>();

        for (ClassMapBuilder builder : builders) {
            builder.byDefault().register();
        }
        return mapperFactory;
    }

    @Bean
    MapperFacade mapperFacade() {
        return mapperFactory().getMapperFacade();
    }
}
