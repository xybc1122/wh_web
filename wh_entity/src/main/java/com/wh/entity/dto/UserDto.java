package com.wh.entity.dto;

import java.util.List;

/**
 * 用户返回前端视图层
 */
public class UserDto {
    /**
     * 用户id
     */
    private String uid;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 账号
     */
    private String userName;

    /**
     * 状态,默认为0，普通用户，1为超级管理员
     */
    private Integer accountStatus;

    /**
     * 类型
     */
    private String type;

    /**
     * 角色id 集合
     */
    private String rids;
    /**
     * 角色名称
     */

    private String rName;

    /**
     * 创建时间
     */
    private Long createDate;
    /**
     * 创建范围时间
     */
    private List<Long> createDates;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;


    private Integer version;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Long> getCreateDates() {
        return createDates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    //    /**
//     * 是否首次登录修改密码(0不修改，1修改密码)
//     */
//    private Boolean isFirstLogin;

//    /**
//     * 最近登陆时间
//     */
//    private Long landingTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getRids() {
        return rids;
    }

    public void setRids(String rids) {
        this.rids = rids;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Boolean getFirstLogin() {
//        return isFirstLogin;
//    }
//
//    public void setFirstLogin(Boolean firstLogin) {
//        isFirstLogin = firstLogin;
//    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}
