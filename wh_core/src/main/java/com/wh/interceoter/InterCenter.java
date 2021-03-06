package com.wh.interceoter;


import com.auth0.jwt.interfaces.Claim;
import com.wh.base.JsonData;
import com.wh.dds.DynamicDataSourceContextHolder;
import com.wh.service.redis.RedisService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 监听器
 */
@Component
public class InterCenter implements HandlerInterceptor {

    /**
     * redis
     */
    @Autowired
    private RedisService redisService;

    @Autowired
    private IWhUserRoleService roleService;


    private static InterCenter interCenter;

    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {
        interCenter = this;
    }


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
        String token = request.getHeader(StaticVariable.SSO_TOKEN);
        if (token == null) {
            //尝试去参数里面获取看看
            token = request.getParameter(StaticVariable.SSO_TOKEN);
        }
        if (token != null) {
            Map<String, Claim> claim = JwtUtils.verifyToken(token);
            if (claim != null) {
                Long uid = claim.get("uid").asLong();

                Integer tid = claim.get("tid") == null ? 0 : claim.get("tid").asInt();

                String userName = claim.get("userName") == null ? "" : claim.get("userName").asString();

                String tenant = claim.get("tenant") == null ? "" : claim.get("tenant").asString();

                String rids = claim.get("rids") == null ? "" : claim.get("rids").asString();

                boolean cAdmin = false;


                String stringKey = interCenter.redisService.getStringKey(RedisService.redisTokenKey(uid.toString(), tenant));
                if (StringUtils.isBlank(stringKey) || !token.equals(stringKey)) {
                    JsonUtils.sendJsonMsg(response, JsonData.
                            setResultError(Constants.HTTP_RESP_CODE, "令牌过期/已有人登陆此账号,请重新登陆"));
                    return false;
                }
                //这里判断频繁请求 api  限制
                if (!accessLimit(request, response, uid)) return false;

                //如果是用户logout
                if (request.getRequestURI().equals(SSOClientUtils.LOGOUT_PATH)) {
                    response.sendRedirect(SSOClientUtils.SERVER_URL + SSOClientUtils.LOGOUT_PATH + "?uid=" + uid + "&tenant=" + tenant);
                    return false;
                }

                // 这里校验是否是admin 如果返回是true 那就是说明他说admin
                //里面逻辑还没写 下周验证
                if (interCenter.roleService.cAdmin(tenant, userName, rids)) {
                    cAdmin = true;
                }
                //设置局部request
                ReqUtils.set(request, uid, userName, rids, tenant, tid, cAdmin);

                //如果请求的是超级管理员配置接口
                if (request.getRequestURI().contains("/api/v1/admin") ||
                        request.getRequestURI().contains("/api/v1/super-admin")) {
                    if (!cAdmin) {
                        //这里做控制
                        JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "你不是admin/无权操作"));
                        return false;
                    }
                }
                if (!tenant.equals("the-host")) {
                    //切换租户
                    DynamicDataSourceContextHolder.setDataSourceKey(tenant);
                }

                return true;
            }
            JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌转换异常,请重新登陆"));
            return false;
        }
        JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "请登录"));
        return false;
    }

    private boolean accessLimit(HttpServletRequest request, HttpServletResponse response, Long uid) {
        // seconds是多少秒内可以访问多少次
        long seconds = 10;
        //5次
        int maxCount = 5;
        String key = request.getRequestURI();
        String tKey = key + "_" + uid;
        //从redis中获取用户访问的次数
        String count = interCenter.redisService.getStringKey(tKey);
        if (count == null) {
            //第一次访问
            interCenter.redisService.setString(tKey, "1", seconds);
        } else if (Integer.parseInt(count) < maxCount) {
            //加1
            interCenter.redisService.setEx(tKey, 1);
        } else {
            //超出访问次数
            JsonUtils.sendJsonMsg(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "访问太频繁,请稍后在试"));
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion");
    }

}
