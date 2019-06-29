package com.wh.entity.out_library.transfer.entry;


import com.wh.entity.parent.ParentConfTable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private String id;
    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;
    /**
     * 调拨出库id
     */
    private String tNumber;

    /**
     * 仓位
     */
    @NotBlank(message = "is null")
    private String position;


    /**
     * sku
     */
    @NotBlank(message = "sku 不能为空")
    private String sku;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
