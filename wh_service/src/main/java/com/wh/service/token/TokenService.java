package com.wh.service.token;

import com.wh.base.ResponseBase;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 10:42
 **/
public interface TokenService {

    /**
     * 创建token
     *
     * @return
     */
    ResponseBase createToken();

    /**
     * 校验token
     *
     * @param request
     */
    void checkToken(HttpServletRequest request);
}
