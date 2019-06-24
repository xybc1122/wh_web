package com.wh.config;

import com.wh.utils.SSOClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//        if (request.getRequestURI().equals(SSOClientUtil.LOGIN_PATH)) {
//            //重定向到sso登陆系统
//            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
//            response.setHeader("Location", SSOClientUtil.SERVER_URL + SSOClientUtil.LOGIN_PATH);
//            return;
//        }
        chain.doFilter(servletRequest, servletResponse);
    }
}
