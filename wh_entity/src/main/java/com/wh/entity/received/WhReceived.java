package com.wh.entity.received;

import java.util.Date;

/**
 * @author yyk
 * @date 2019/7/10 15:38
 * @description 收货单
 */
public class WhReceived {
    private int id;
    /**
     单号
     */
    private String no;
    /**
     采购单号
     */
    private String foreignNo;
    /**
     采购员
     */
    private int userId;
    /**
     操作时间
     */
    private Date createdAt;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 类型
     */
    private int type;

    public WhReceived() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WhReceived(int id, String no, String foreignNo, int userId, Date createdAt) {
        this.id = id;
        this.no = no;
        this.foreignNo = foreignNo;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getForeignNo() {
        return foreignNo;
    }

    public void setForeignNo(String foreignNo) {
        this.foreignNo = foreignNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
