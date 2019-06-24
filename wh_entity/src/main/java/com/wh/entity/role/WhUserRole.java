package com.wh.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */

public class WhUserRole extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "r_id", type = IdType.AUTO)
    private Long rid;

    /**
     * 角色名称
     */
    private String rName;

    /**
     * 角色标识
     */
    private String roleSign;

    /**
     * 配置菜单 id 集合
     */
    @TableField(exist = false)
    private List<Integer> menus;


    /**
     * 接收的rids
     */
    @TableField(exist = false)
    private String rIds;

    /**
     * 接收权限列表集合 ,号分割
     */
    @TableField(exist = false)
    private String pName;

    /**
     * 接收权限列表 id 集合  ,号分割
     */
    @TableField(exist = false)
    private String pids;

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Integer> getMenus() {
        return menus;
    }

    public void setMenus(List<Integer> menus) {
        this.menus = menus;
    }

    public WhUserRole(String rName) {
        this.rName = rName;
    }

    public WhUserRole() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getrIds() {
        return rIds;
    }

    public void setrIds(String rIds) {
        this.rIds = rIds;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }
}
