package com.wh.entity.meun;

import com.wh.entity.parent.ParentTree;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */

public class WhUserMenu extends ParentTree implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    /**
     * 菜单权限浏览
     */
    private String perms;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }
}
