package com.wh.entity.box;

import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;

import java.util.List;

/**
 * 箱子
 */
public class Box {


    /**
     * 跟踪号
     */
    private String trackingNumber;
    /**
     * 规格
     */
    private String specification;


    /**
     * 条目表
     */
    private List<WhFbaStockingEntry> entry;


    private String sn;


    public Box(String trackingNumber, String specification, String sn) {
        this.trackingNumber = trackingNumber;
        this.specification = specification;
        this.sn = sn;
    }

    public Box() {

    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<WhFbaStockingEntry> getEntry() {
        return entry;
    }

    public void setEntry(List<WhFbaStockingEntry> entry) {
        this.entry = entry;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Box{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
