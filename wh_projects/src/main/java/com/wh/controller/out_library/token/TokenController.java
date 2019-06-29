package com.wh.controller.out_library.token;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.token.TokenService;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.RedisUtils;
import com.wh.utils.SnowflakeUtils;
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
    public ResponseBase createToken() {
        return tokenService.createToken();
    }

}
