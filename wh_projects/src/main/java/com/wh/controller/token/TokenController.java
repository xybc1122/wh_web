package com.wh.controller.token;

import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.token.TokenService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TokenController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 10:11
 **/
@RestController
@RequestMapping("/api/v1/to")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    /**
     * 创建幂等token
     *
     * @return
     */
    @GetMapping("/createToken")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase createToken() {
        return tokenService.createToken();
    }

}
