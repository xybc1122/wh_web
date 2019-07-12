package com.wh.entity.dto;

/**
 * @ClassName FbaStockingEntryDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 9:14
 **/
public class FbaStockingEntryDto {

    /**
     * 标识ID
     */
    private String id;
    /**
     * 产品sku
     */
    private String sku;

    /**
     * fn_sku
     */
    private String fnSku;

    /**
     * 名称
     */
    private String fseName;

    /**
     * 备货数量
     */

    private Integer quantity;

    /**
     * fba备货id
     */
    private String sn;
    /**
     * 亚马逊单号
     */

    private String recordNum;
    /**
     * 库存
     */
    private Integer inStock;
    /**
     * 实际出库数量
     */
    private Integer actualQuantity;
    /**
     * 版本标识
     */
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Integer getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Integer actualQuantity) {
        this.actualQuantity = actualQuantity;
    }
}
