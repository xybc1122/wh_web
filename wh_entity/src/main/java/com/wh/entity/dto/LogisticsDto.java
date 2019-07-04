package com.wh.entity.dto;

/**
 * @ClassName LogisticsDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 9:53
 **/
public class LogisticsDto {


    private Long id;
    /**
     * 运输方式名
     */
    private String transport;







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
}
