package com.wh.entity.rp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
public class WhUserRolePerms extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    private Long pId;


    /**
     * 角色id
     */
    private Long rId;
    /**
     * 角色名称
     */
    @TableField(exist = false)
    private String rName;

    public WhUserRolePerms(Long rId, Long pId) {
        this.pId = pId;
        this.rId = rId;
    }

    public WhUserRolePerms() {

    }

    /**
     * 权限集合   Id
     */
    @TableField(exist = false)
    private List<Integer> perms;

    /**
     * 标识id
     */
    @TableId(value = "pr_id", type = IdType.AUTO)
    private Integer prId;


    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public List<Integer> getPerms() {
        return perms;
    }

    public void setPerms(List<Integer> perms) {
        this.perms = perms;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }
}
