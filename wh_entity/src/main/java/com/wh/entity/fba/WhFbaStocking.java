package com.wh.entity.fba;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.fba.entry.WhFbaStockingEntry;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * fba 备货
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public class WhFbaStocking extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 单号
     */
    private String recordNo;

    /**
     * 单号状态
     */
    private String fsStatus;

    /**
     * 站点
     */
    private String site;

    /**
     * 收货信息
     */
    private String dInformation;

    /**
     * 物流方式/跟踪号
     */
    private String shipMethods;

    /**
     * 包装数量
     */
    private Integer nOfBoxes;

    /**
     * 账号
     */
    private String aNumber;


    /**
     * 条目表
     */
    private List<WhFbaStockingEntry> entry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WhFbaStockingEntry> getEntry() {
        return entry;
    }

    public void setEntry(List<WhFbaStockingEntry> entry) {
        this.entry = entry;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public String getFsStatus() {
        return fsStatus;
    }

    public void setFsStatus(String fsStatus) {
        this.fsStatus = fsStatus;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getdInformation() {
        return dInformation;
    }

    public void setdInformation(String dInformation) {
        this.dInformation = dInformation;
    }

    public String getShipMethods() {
        return shipMethods;
    }

    public void setShipMethods(String shipMethods) {
        this.shipMethods = shipMethods;
    }

    public Integer getnOfBoxes() {
        return nOfBoxes;
    }

    public void setnOfBoxes(Integer nOfBoxes) {
        this.nOfBoxes = nOfBoxes;
    }

    public String getaNumber() {
        return aNumber;
    }

    public void setaNumber(String aNumber) {
        this.aNumber = aNumber;
    }
}
