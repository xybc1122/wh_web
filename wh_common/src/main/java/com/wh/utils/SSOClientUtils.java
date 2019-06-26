package com.wh.utils;

import com.wh.config.SsoYmlConfig;

public class SSOClientUtils {

    public static String SERVER_URL;//统一认证中心地址:
    public static String LOGIN_PATH;//登陆的路径
    public static String LOGOUT_PATH;//退出的路径

    /**
     * 加载配置文件
     *
     * @param ssoYmlConfig
     */
    public static void setParameter(SsoYmlConfig ssoYmlConfig) {
        SERVER_URL = ssoYmlConfig.getSsoServer();
        LOGIN_PATH = ssoYmlConfig.getLoginPath();
        LOGOUT_PATH = ssoYmlConfig.getLogoutPath();
    }
}
