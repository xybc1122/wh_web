package com.wh.entity.ot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 * 操作权限类型实体
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
@TableName("wh_user_operating")
public class WhUserOperatingType extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识id
     */
    @TableId(value = "o_id", type = IdType.AUTO)
    private Long oId;

    /**
     * 操作名称
     */
    private String tName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
