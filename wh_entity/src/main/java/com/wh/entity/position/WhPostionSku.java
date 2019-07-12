package com.wh.entity.position;

public class WhPostionSku {
    private int id;
    /**
     * sku編碼
     */
    private String asin;
    /**
     * 实际库存
     */
    private int stock;

    /**
     * 配货库存
     */
    private int scanStock;

    public WhPostionSku() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getScanStock() {
        return scanStock;
    }

    public void setScanStock(int scanStock) {
        this.scanStock = scanStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }
}
