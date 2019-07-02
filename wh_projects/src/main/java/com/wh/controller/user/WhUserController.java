package com.wh.controller.user;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.user.UserService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WhUserController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/27 14:30
 **/
@RestController
@RequestMapping("/api/v1/user")
public class WhUserController {

    @Autowired
    private UserService userService;


    /**
     * 查询采购员信息
     *
     * @return
     */
    @GetMapping("/findUserByRName")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase findUserByRName() {
        return userService.serviceSelUserByRName("采购员");
    }


}
