package com.wh.entity.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 * 权限操作信息表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */

public class WhUserApi extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识id
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Long aId;

    /**
     * api 请求url
     */
    private String apiUrl;

    /**
     * 操作的接口名称
     */
    private String aName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }
}
