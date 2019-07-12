package com.wh.entity.dto;

import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;

import java.util.List;

/**
 * @ClassName BoxDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/8 11:21
 **/
public class BoxDto {

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
    private List<FbaStockingEntryDto> entry;


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

    public List<FbaStockingEntryDto> getEntry() {
        return entry;
    }

    public void setEntry(List<FbaStockingEntryDto> entry) {
        this.entry = entry;
    }
}
