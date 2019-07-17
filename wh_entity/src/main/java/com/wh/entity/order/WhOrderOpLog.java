package com.wh.entity.order;

/**
 * @author yyk
 * @date 2019/7/12 15:52
 * @description 订单出库操作记录表
 */
public class WhOrderOpLog {
    /**
     * 包裹号
     */
    private int packageNum;

    public WhOrderOpLog() {
    }

    public int getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(int packageNum) {
        this.packageNum = packageNum;
    }

    public WhOrderOpLog(int packageNum) {
        this.packageNum = packageNum;
    }
}
