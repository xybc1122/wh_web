package com.wh.interceoter;

import com.wh.toos.StaticVariable;
import com.wh.utils.ReqUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignRequestInterceptor
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/10 9:41
 * feign请求拦截器
 * 所有用feign发出的请求的拦截器，注意是feign作为客户端发出请求的，而不是服务端
 **/
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("feign");
        requestTemplate.header(StaticVariable.SSO_TOKEN, ReqUtils.getSsoToken());
    }
}
