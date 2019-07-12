package com.wh.entity.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName FbaStockingDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 9:13
 **/
public class FbaStockingDto {


    /**
     * 标识ID
     */
    private Long id;
    /**
     * 站点id
     */
    private Integer siteId;
    /**
     * 账号ID
     */
    private Integer accountId;
    /**
     * 物流id
     */
    private Integer transportId;

    /**
     * 记录号
     */
    private String singleNumber;

    /**
     * 单号状态
     */
    private Integer fsState;
    /**
     * 收货信息
     */
    private String dInformation;

    /**
     * 物流方式名
     */
    private String transport;

    /**
     * 包装数量
     */
    private Integer nOfBoxes;


    /**
     * 单据号
     */
    private String recordNo;

    /**
     * 单据日期
     */
    private Long documentTime;
    /**
     * 记录编号
     */
    private String recordNum;
    /**
     * 运送时间
     */
    private Long shippingTime;


    /**
     * 箱子表
     */
    private List<BoxDto> boxes;

    /**
     * 账号
     */
    private String account;
    /**
     * 版本标识
     */
    private Integer version;
    /**
     * 站点
     */
    private String site;
    /**
     * 总量
     */
    private Integer totalAmount;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 创建时间
     */
    private Long createDate;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public String getdInformation() {
        return dInformation;
    }

    public void setdInformation(String dInformation) {
        this.dInformation = dInformation;
    }

    public Integer getnOfBoxes() {
        return nOfBoxes;
    }

    public void setnOfBoxes(Integer nOfBoxes) {
        this.nOfBoxes = nOfBoxes;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Long getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(Long documentTime) {
        this.documentTime = documentTime;
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

    public List<BoxDto> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxDto> boxes) {
        this.boxes = boxes;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
