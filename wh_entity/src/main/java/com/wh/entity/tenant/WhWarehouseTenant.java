package com.wh.entity.tenant;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */

public class WhWarehouseTenant extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    @TableId(value = "tenant_id", type = IdType.AUTO)
    private Long tenantId;

    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * db url
     */
    private String dbUrl;
    /**
     * db 姓名
     */
    private String dbName;
    /**
     * db密码
     */
    private String dbPwd;
    /**
     * 标识
     */
    private String tenant;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
