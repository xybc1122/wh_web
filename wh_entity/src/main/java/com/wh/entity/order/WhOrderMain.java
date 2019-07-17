package com.wh.entity.order;

import java.util.Date;

/**
 * @author yyk
 * @date 2019/7/11 14:33
 * @description 主订单表
 */
public class WhOrderMain {
    private int id;
    /**
     * 平台订单单号
     */
    private String recordNum;
    /**
     * 快递单号
     */
    private String mailNo;
    /**
     * 出库时间
     */
    private Date checkoutAt;

    /**
     * 包装员id
     */
    private int packUid;

    public int getPackUid() {
        return packUid;
    }

    public void setPackUid(int packUid) {
        this.packUid = packUid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public Date getCheckoutAt() {
        return checkoutAt;
    }

    public void setCheckoutAt(Date checkoutAt) {
        this.checkoutAt = checkoutAt;
    }

    public WhOrderMain() {
    }

    public WhOrderMain(int id, String recordNum, String mailNo, Date checkoutAt) {
        this.id = id;
        this.recordNum = recordNum;
        this.mailNo = mailNo;
        this.checkoutAt = checkoutAt;
    }
}
