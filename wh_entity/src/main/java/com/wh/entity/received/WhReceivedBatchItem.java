package com.wh.entity.received;

import java.util.Date;

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

    /**
     * 检测时间
     */
    private Date qcDate;
    /**
     * 检测人
     */
    private int qcUid;
    /**
     *单号
     */
    private int received_id;

    public WhReceivedBatchItem(int id, String asin, int status, int stockNumber, Date qcDate, int qcUid, int received_id) {
        this.id = id;
        this.asin = asin;
        this.status = status;
        this.stockNumber = stockNumber;
        this.qcDate = qcDate;
        this.qcUid = qcUid;
        this.received_id = received_id;
    }

    public Date getQcDate() {
        return qcDate;
    }

    public void setQcDate(Date qcDate) {
        this.qcDate = qcDate;
    }

    public int getQcUid() {
        return qcUid;
    }

    public void setQcUid(int qcUid) {
        this.qcUid = qcUid;
    }

    public int getReceived_id() {
        return received_id;
    }

    public void setReceived_id(int received_id) {
        this.received_id = received_id;
    }

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
