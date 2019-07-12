package com.wh.fiter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName SsoTokenFilter
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/20 9:53
 **/
@WebFilter(urlPatterns = "/*", filterName = "SsoTokenFilter")
@Order(0)
public class SsoTokenFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //如果是用户登陆
//        if (request.getRequestURI().equals(SSOClientUtils.LOGIN_PATH)) {
//            //重定向到sso登陆系统
//            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
//            response.setHeader("Location", SSOClientUtils.SERVER_URL + SSOClientUtils.LOGIN_PATH);
//            return;
//        }
        chain.doFilter(servletRequest, servletResponse);
    }
}
