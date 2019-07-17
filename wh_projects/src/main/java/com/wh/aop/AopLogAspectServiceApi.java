package com.wh.aop;

import com.alibaba.fastjson.JSONObject;
import com.wh.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
// 申明是个spring管理的bean
@Component
public class AopLogAspectServiceApi {
    private JSONObject jsonObject = new JSONObject();

    //自定义日志
    private Logger aopLogger =LoggerFactory.getLogger("aopLogger");


    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.wh.controller..*.*(..))")
    private void controllerAspect() {
    }

    // 请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            aopLogger.info("===============请求内容===============");
            try {
                String ip = IpUtils.getIpAddr(request);
                // 打印请求内容
                aopLogger.info("请求地址:" + request.getRequestURL().toString());
                aopLogger.info("请求的IP:" + ip);
                aopLogger.info("请求方式:" + request.getMethod());
                aopLogger.info("请求类方法:" + joinPoint.getSignature());
                aopLogger.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
            } catch (Exception e) {
                aopLogger.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
            }
            aopLogger.info("===============请求内容===============");
        } else {
            aopLogger.error("###LogAspectServiceApi.class methodBefore() ### ERROR:" + requestAttributes);
        }

    }

    // 在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturing(Object o) {
        aopLogger.info("--------------返回内容----------------");
        try {
            aopLogger.info("Response内容:" + jsonObject.toJSONString(o));
        } catch (Exception e) {
            aopLogger.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
        }
        aopLogger.info("--------------返回内容----------------");
    }
}
