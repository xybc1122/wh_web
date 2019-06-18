package com.wh.entity.type;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wh.entity.parent.ParentConfTable;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@TableName("wh_type")
public class WhType extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型id
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 类型名称
     */
    private String tName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
