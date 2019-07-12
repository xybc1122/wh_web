package com.wh.entity.product;

/**
 * 产品表
 */
public class WhProduct {
    private int id;
    /**
     * 图片
     */
    private String picJson;
    /**
     * 重量
     */
    private double weight;
    /**
     * 是否为真品
     */
    private int isNew;
    /**
     * 供应商
     */
    private int supplierId;
    /**
     * 产品状态
     */
    private int goodStatus;
    /**
     * 采购人
     */
    private String purchaseUser;
    /**
     * 产品中文名称
     */
    private String nameCn;

    /**
     * 采购价格
     */
    private double pricePurchase;

    private String asin;

    public double getPricePurchase() {
        return pricePurchase;
    }

    public void setPricePurchase(double pricePurchase) {
        this.pricePurchase = pricePurchase;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public WhProduct(int id, String picJson, double weight, int isNew, int supplierId, int goodStatus, String purchaseUser, String nameCn) {
        this.id = id;
        this.picJson = picJson;
        this.weight = weight;
        this.isNew = isNew;
        this.supplierId = supplierId;
        this.goodStatus = goodStatus;
        this.purchaseUser = purchaseUser;
        this.nameCn = nameCn;
    }

    public WhProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicJson() {
        return picJson;
    }

    public void setPicJson(String picJson) {
        this.picJson = picJson;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getPurchaseUser() {
        return purchaseUser;
    }

    public void setPurchaseUser(String purchaseUser) {
        this.purchaseUser = purchaseUser;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
}
