package com.wh.entity.site;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
public class WhSite implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标识id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String site;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
