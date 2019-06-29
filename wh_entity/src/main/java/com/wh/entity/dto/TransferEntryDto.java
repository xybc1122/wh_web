package com.wh.entity.dto;

/**
 * @ClassName TransferEntryDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/28 8:52
 **/
public class TransferEntryDto {

    /**
     * sku
     */
    private String sku;

    /**
     * 标识ID
     */
    private String id;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 调拨出库id
     */
    private String tNumber;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }
}
