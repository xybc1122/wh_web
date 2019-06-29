package com.wh.config;

import com.wh.toos.StaticVariable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName ConstantsConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 8:58
 **/
@Component
@ConfigurationProperties(prefix = "static.variable")
public class ConstantsConfig {

    /**
     * token
     */
    private String ssoToken;

    /**
     * 管理员reid key
     */
    private String admin;
    /**
     * 调拨订单头标识
     */
    private String db;
    /**
     * 调拨条目ID头标识
     */
    private String dbEId;

    /**
     * fba头标识
     */
    private String fba;
    /**
     * fba条目ID头标识
     */
    private String fbaEId;

    /**
     * 幂等token 头标识
     */
    private String ideToken;


    public String getFbaEId() {
        return fbaEId;
    }

    public void setFbaEId(String fbaEId) {
        this.fbaEId = fbaEId;
    }

    public String getDbEId() {
        return dbEId;
    }

    public void setDbEId(String dbEId) {
        this.dbEId = dbEId;
    }

    public String getSsoToken() {
        return ssoToken;
    }

    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getFba() {
        return fba;
    }

    public void setFba(String fba) {
        this.fba = fba;
    }

    public String getIdeToken() {
        return ideToken;
    }

    public void setIdeToken(String ideToken) {
        this.ideToken = ideToken;
    }


    @PostConstruct
    public void init() {
        StaticVariable.setParameter(this);
    }

}
