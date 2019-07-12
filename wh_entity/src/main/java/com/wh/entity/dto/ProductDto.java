package com.wh.entity.dto;

/**
 * 产品详情表
 * @author yyk
 */
public class ProductDto {
    /**
     * sku
     */
    private String sku;
    /**
     * 仓位id
     */
    private String option_id;
    /**
     * 实际重量
     */
    private double weight;
    /**
     * 采购员
     */
    private String purchaser;
    /**
     * 供应商
     */
    private int supplier;
    /**
     * 是否新品
     */
    private int isNew;
    /**
     * 产品状态
     */
    private int goodStatus;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 图片地址
     */
    private String picture;
    /**
     * 货值
     */
    private double totalPrice;
    /**
     * 可用库存
     */
    private int availStock;
    /**
     * 真实库存
     */
    private int actualStock;
    /**
     * 到货库存
     */
    private int arrivalStock;
    /**
     * 缺货库存
     */
    private int shortStock;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAvailStock() {
        return availStock;
    }

    public void setAvailStock(int availStock) {
        this.availStock = availStock;
    }

    public int getActualStock() {
        return actualStock;
    }

    public void setActualStock(int actualStock) {
        this.actualStock = actualStock;
    }

    public int getArrivalStock() {
        return arrivalStock;
    }

    public void setArrivalStock(int arrivalStock) {
        this.arrivalStock = arrivalStock;
    }

    public int getShortStock() {
        return shortStock;
    }

    public void setShortStock(int shortStock) {
        this.shortStock = shortStock;
    }

    public ProductDto() {
    }

    public ProductDto(String sku, String option_id, double weight, String purchaser, int supplier, int isNew, int goodStatus, String name, String picture, double totalPrice, int availStock, int actualStock, int arrivalStock, int shortStock) {
        this.sku = sku;
        this.option_id = option_id;
        this.weight = weight;
        this.purchaser = purchaser;
        this.supplier = supplier;
        this.isNew = isNew;
        this.goodStatus = goodStatus;
        this.name = name;
        this.picture = picture;
        this.totalPrice = totalPrice;
        this.availStock = availStock;
        this.actualStock = actualStock;
        this.arrivalStock = arrivalStock;
        this.shortStock = shortStock;
    }

}
