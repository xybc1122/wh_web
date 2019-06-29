package com.wh.aop;

import com.wh.exception.LsException;
import com.wh.service.token.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AopIdempotentCheck
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 10:57
 **/
@Aspect
@Component
@Order(1)
public class AopIdempotentCheck {
    @Autowired
    private TokenService tokenService;

    @Pointcut("@annotation(com.wh.customize.IdempotentCheck)")
    public void addIdempotentCheckPointcut() {


    }

    @Around(value = "addIdempotentCheckPointcut()")
    public Object addKeyMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            tokenService.checkToken(request);
            return joinPoint.proceed();
        }
        throw new LsException("requestAttributes is null");

    }

}
