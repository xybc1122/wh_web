package com.wh.entity.out_library.fba.entry;


import com.wh.entity.parent.ParentConfTable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * fbs 备货 条目表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public class WhFbaStockingEntry extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标识ID
     */
    private String id;
    /**
     * 产品sku
     */
    @NotBlank(message = "sku不能为空")
    private String sku;

    /**
     * fn_sku
     */
    @NotBlank(message = "fnSku不能为空")
    private String fnSku;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String fseName;

    /**
     * 备货数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;

    /**
     * fba备货id
     */
    private String rNo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku;
    }

    public String getFseName() {
        return fseName;
    }

    public void setFseName(String fseName) {
        this.fseName = fseName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getrNo() {
        return rNo;
    }

    public void setrNo(String rNo) {
        this.rNo = rNo;
    }
}
