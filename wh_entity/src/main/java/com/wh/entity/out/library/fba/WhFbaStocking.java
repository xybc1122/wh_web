package com.wh.entity.out.library.fba;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.out.library.fba.entry.WhFbaStockingEntry;
import com.wh.entity.parent.ParentConfTable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Integer fsState;

    /**
     * 站点
     */
    @NotBlank(message = "is null")
    private String site;

    /**
     * 收货信息
     */
    @NotBlank(message = "is null")
    private String dInformation;

    /**
     * 物流方式/跟踪号
     */
    @NotBlank(message = "is null")
    private String shipMethods;

    /**
     * 包装数量
     */
    @NotNull(message = "is null")
    private Integer nOfBoxes;

    /**
     * 账号
     */
    @NotBlank(message = "is null")
    private String account;

    /**
     * 单据号
     */
    private String documentNo;

    /**
     * 单据日期
     */
    private Long  documentTime;
    /**
     * 记录编号
     */
    private String recordNum;
    /**
     * 运送时间
     */
    private Long  shippingTime;



    /**
     * 条目表
     */
    @TableField(exist = false)
    @Size(min = 1, message = "is null or length =0")
    @Valid
    private List<WhFbaStockingEntry> entry;


    public Long getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(Long documentTime) {
        this.documentTime = documentTime;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public Long getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Long shippingTime) {
        this.shippingTime = shippingTime;
    }

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

    public Integer getFsState() {
        return fsState;
    }

    public void setFsState(Integer fsState) {
        this.fsState = fsState;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
