package com.wh.interceoter;


import com.auth0.jwt.interfaces.Claim;
import com.wh.base.JsonData;
import com.wh.dds.DynamicDataSourceContextHolder;
import com.wh.toos.Constants;
import com.wh.utils.JsonUtils;
import com.wh.utils.JwtUtils;
import com.wh.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 监听器
 */
public class InterCenter implements HandlerInterceptor {


//    @Autowired
//    private RedisService redisService;
//
//    private static InterCenter interCenter;
//
//    //通过@PostConstruct实现初始化bean之前进行的操作
//    @PostConstruct
//    public void init() {
//        interCenter = this;
//    }

    /**
     * 用户登录进入controller层之前 进行拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //判斷地址栏中是否有携带token参数
        String token = request.getHeader(Constants.SSO_TOKEN);
        if (token == null) {
            //尝试去参数里面获取看看
            token = request.getParameter(Constants.SSO_TOKEN);
        }
        if (token != null) {
            Map<String, Claim> claim = JwtUtils.verifyToken(token);
            if (claim != null) {
                Claim uid = claim.get("uid");
                Claim userName = claim.get("userName");
                Claim rids = claim.get("rids");
                Claim tenant = claim.get("tenant");
                //设置局部request
                ReqUtils.set(request, uid.asLong(), userName.asString(), rids.asString(), tenant.asString());
                //切换租户
                DynamicDataSourceContextHolder.setDataSourceKey(tenant.asString());
                //如果请求的是超级管理员配置接口
                if (request.getRequestURI().contains("/api/v1/admin")) {
                    //这里做控制
                }
                return true;
            }
            JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌转换异常"));
            return false;
        }
        JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "请登录"));
        return false;
    }

}
