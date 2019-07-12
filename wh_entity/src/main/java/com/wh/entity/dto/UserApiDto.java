package com.wh.entity.dto;

/**
 * @ClassName UserApiDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/11 12:45
 **/
public class UserApiDto {



    private Long aId;

    /**
     * api 请求url
     */
    private String apiUrl;

    /**
     * 操作的接口名称
     */
    private String aName;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }
}
