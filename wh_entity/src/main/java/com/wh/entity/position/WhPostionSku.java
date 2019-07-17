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
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 批次子类id
     */
    private Integer batchItemId;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getBatchItemId() {
        return batchItemId;
    }

    public void setBatchItemId(Integer batchItemId) {
        this.batchItemId = batchItemId;
    }

    public WhPostionSku(int id, String asin, int stock, int scanStock, String batchNo, int batchItemId) {
        this.id = id;
        this.asin = asin;
        this.stock = stock;
        this.scanStock = scanStock;
        this.batchNo = batchNo;
        this.batchItemId = batchItemId;
    }

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
