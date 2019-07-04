package com.wh.service.account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.account.WhSellerAccount;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
public interface IWhSellerAccountService extends IService<WhSellerAccount> {

    /**
     * 查询账号 下拉框
     *
     * @return
     */
    ResponseBase serviceGetAccountIdAndName();


    /**
     * 通过 账号 名查询账号 id
     *
     * @param account
     * @return
     */
    Integer serviceSelIdByName(String account);

}
