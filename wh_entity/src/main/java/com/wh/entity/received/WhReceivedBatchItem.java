package com.wh.entity.received;

/**
 * 收获表
 */
public class WhReceivedBatchItem {
        private int id;
        private String asin;
    /**
     * 状态
     */
    private int status;
    /**
     * 上架数量
     */
        private int stockNumber;

    public WhReceivedBatchItem() {
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
