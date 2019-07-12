package com.wh.entity.dto;

/**
 * @ClassName UserOperatingTypeDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/11 11:21
 **/
public class UserOperatingTypeDto {


    private Long oId;

    private String tName;

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
