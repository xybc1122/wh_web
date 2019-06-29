package com.wh.customize;

import java.lang.annotation.*;

/**
 * @ClassName IdempotentCheck
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 10:57
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface IdempotentCheck {

    /**
     * 是否要校验
     *
     * @return
     */
    String type();
}
