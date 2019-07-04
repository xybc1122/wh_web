package com.wh.service.token.impl;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.exception.LsException;
import com.wh.service.token.TokenService;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.RedisUtils;
import com.wh.utils.SnowflakeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 10:44
 **/
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private SnowflakeUtils snowflakeUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public ResponseBase createToken() {
        String ideToken = StaticVariable.IDE_TOKEN + snowflakeUtils.nextId();
        //这里设置3分钟
        redisUtils.setString(ideToken, ideToken, Constants.EXPIRE_TIME_MINUTE);
        return JsonData.setResultSuccess("success", ideToken);
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(StaticVariable.IDE_TOKEN);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(StaticVariable.IDE_TOKEN);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new LsException("ide-token is null");
            }
        }
        if (!redisUtils.exists(token)) {
            throw new LsException("请勿重复提交");
        }
        //这里一定要判断 不然就会出现并发重复提交的问题
        if (!redisUtils.delKey(token)) {
            throw new LsException("ide-token删除失败");
        }
        System.out.println("接口幂等校验成功");
    }
}
