package com.wh.entity.product;

/**
 * 产品对应的sku表
 */
public class WhProductSku {
    private int id;
    /**
     * sku信息
     */
    private String skuInfo;

    private String asin;
    private String spu_asin;

    public WhProductSku() {
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getSpu_asin() {
        return spu_asin;
    }

    public void setSpu_asin(String spu_asin) {
        this.spu_asin = spu_asin;
    }

    public WhProductSku(String skuInfo, String asin, String spu_asin) {
        this.skuInfo = skuInfo;
        this.asin = asin;
        this.spu_asin = spu_asin;
    }

    public String getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(String skuInfo) {
        this.skuInfo = skuInfo;
    }

    public WhProductSku(String skuInfo) {
        this.skuInfo = skuInfo;
    }
}
