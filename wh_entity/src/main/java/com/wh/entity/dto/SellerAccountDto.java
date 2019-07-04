package com.wh.entity.dto;

/**
 * @ClassName SellerAccountDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 9:43
 **/
public class SellerAccountDto {


    private Long id;
    /**
     * 销售账号名
     */
    private String account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
