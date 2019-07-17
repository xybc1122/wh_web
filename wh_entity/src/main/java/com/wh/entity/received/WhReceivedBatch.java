package com.wh.entity.received;

import java.util.Date;

/**
 * @author yyk
 * @date 2019/7/12 11:16
 * @description 批次子类
 */
public class WhReceivedBatch {
    private int id;
    /**
     * 是否点货上架
     */
    private int status;
    /**
     * 是否完成质检
     */
    private int qcFinshed;
    /**
     * 总数
     */
    private int totalNumber;
    /**
     * 点货员
     */
    private int tallyUid;
    /**
     * 点货时间
     */
    private Date tallyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQcFinshed() {
        return qcFinshed;
    }

    public void setQcFinshed(int qcFinshed) {
        this.qcFinshed = qcFinshed;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTallyUid() {
        return tallyUid;
    }

    public void setTallyUid(int tallyUid) {
        this.tallyUid = tallyUid;
    }

    public Date getTallyDate() {
        return tallyDate;
    }

    public void setTallyDate(Date tallyDate) {
        this.tallyDate = tallyDate;
    }

    public WhReceivedBatch() {
    }

    public WhReceivedBatch(int id, int status, int qcFinshed, int totalNumber, int tallyUid, Date tallyDate) {
        this.id = id;
        this.status = status;
        this.qcFinshed = qcFinshed;
        this.totalNumber = totalNumber;
        this.tallyUid = tallyUid;
        this.tallyDate = tallyDate;
    }
}
