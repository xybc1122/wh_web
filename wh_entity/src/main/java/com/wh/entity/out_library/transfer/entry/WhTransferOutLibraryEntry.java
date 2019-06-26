package com.wh.entity.out_library.transfer.entry;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public class WhTransferOutLibraryEntry extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标识ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * sku
     */
    private String sku;

    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 调拨出库id
     */
    private Long tId;

    /**
     * 仓位
     */
    private String position;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
