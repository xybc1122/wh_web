package com.wh.controller.account;

import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.account.IWhSellerAccountService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WhSellerAccountController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 9:39
 **/
@RestController
@RequestMapping("/api/v1/account")
public class WhSellerAccountController {
    @Autowired
    private IWhSellerAccountService accountService;


    /**
     * 查询销售账号表  值需要 id 跟 账号名
     *
     * @return
     */
    @GetMapping("/getAccountIdAndName")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase getAccountIdAndName() {
        return accountService.serviceGetAccountIdAndName();

    }


}
