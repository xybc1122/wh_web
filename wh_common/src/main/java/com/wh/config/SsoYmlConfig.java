package com.wh.config;

import com.wh.utils.SSOClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ClassName SsoYmlConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/20 10:34
 **/
@Configuration
public class SsoYmlConfig {
    @Value("${sso.server}")
    private String ssoServer;
    @Value("${sso.login.path}")
    private String loginPath;
    @Value("${sso.logout.path}")
    private String logoutPath;

    public String getLogoutPath() {
        return logoutPath;
    }

    public void setLogoutPath(String logoutPath) {
        this.logoutPath = logoutPath;
    }

    public String getSsoServer() {
        return ssoServer;
    }

    public void setSsoServer(String ssoServer) {
        this.ssoServer = ssoServer;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    @PostConstruct
    public void init() {
        SSOClientUtils.setParameter(this);
    }

}
