package com.wh.aop;


import com.wh.customize.PermissionCheck;
import com.wh.exception.LsException;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName PermissionAspect
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/15 10:16
 **/

@Aspect
@Component
public class AopPermissionAspect {

    @Autowired
    private IWhUserPermsService permsService;

    //定义切点
    @Pointcut("@annotation(com.wh.customize.PermissionCheck)")
    public void doAspect() {

    }

    //前置通知（不需要获取输入参数）
    @Before("doAspect()")
    public void doBefore(JoinPoint joinPoint) {
        // system.out.println("开始前置通知");
        //获取注解
        String v = Objects.requireNonNull(giveController(joinPoint)).value();
        //权限校验
        permCheck(v);
    }

    //最终通知
//    @After("doAspect()")
//    public void doAfter(JoinPoint joinPoint) {
//        system.out.println("最终通知");
//
//    }

    //后置通知(不需要获取返回值)
//    @AfterReturning("doAspect()")
//    public void doAfterReturning(JoinPoint joinPoint) {
//        system.out.println("后置【try】通知");
//    }

    //例外通知(不需要异常信息)
//    @AfterThrowing("doAspect()")
//    public void doAfterThrowing() {
//        system.out.println("后置【catch】通知");
//    }

    //环绕通知
//    @Around("doAspect()")
//    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        system.out.println("环绕通知进入方法");
//        Object object = pjp.proceed();
//        system.out.println("环绕通知退出方法");
//        return object;
//    }

    /**
     * 权限校验
     *
     * @param v
     */
    public void permCheck(String v) {
        if (StringUtils.isNotBlank(v)) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                // System.out.println(request.getRequestURI());
                //先去查一下是不是admin
                Set<String> permsSetAdmin = permsService.serviceGetPermission(ReqUtils.getRoleId(), "/*");
                if (permsSetAdmin != null && permsSetAdmin.size() > 0) {
                    for (String p : permsSetAdmin) {
                        //代表所有操作权限集合
                        if ("ANY".equals(p)) {
                            return;
                        }
                    }
                }
                //如果不是 在去查查有没有权限
                Set<String> permsSet = permsService.serviceGetPermission(ReqUtils.getRoleId(), request.getRequestURI());
                if (permsSet != null && permsSet.size() > 0) {
                    int strIndex = v.indexOf(",");
                    //strIndex!=-1说明有多个权限
                    if (strIndex != -1) {
                        String[] perm = v.split(",");
                        //如果 接口的权限长度  比 用户长  这里是判断多个组合权限
                        if (perm.length > permsSet.size()) {
                            throw new LsException("无权操作");
                        }
                        for (String strPerm : perm) {
                            boolean isTrue = false;
                            for (String strPer : permsSet) {
                                if (strPer.equals(strPerm)) {
                                    isTrue = true;
                                    break;
                                }
                            }
                            if (!isTrue) {
                                throw new LsException("无权操作");
                            }
                        }
                        //正常
                        return;
                    }
                    //说明只有一个权限
                    for (String strPer : permsSet) {
                        //这里只要有个一个对上了 直接return 说明已经授权
                        if (v.equals(strPer)) {
                            //正常
                            return;
                        }
                    }
                }
                throw new LsException("无权操作");
            }
            throw new LsException("request is Null");
        }
        throw new LsException("权限参数 is Null");

    }

    /**
     * 获得注解
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private static PermissionCheck giveController(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(PermissionCheck.class);
        }
        return null;
    }

}
