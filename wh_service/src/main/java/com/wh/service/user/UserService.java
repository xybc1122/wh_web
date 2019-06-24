package com.wh.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserDto;
import com.wh.entity.user.UserInfo;

import java.util.List;


public interface UserService extends IService<UserInfo> {


    //查询用户信息
    ResponseBase getByUserInfoList(UserDto userDto);

    //修改用户
    ResponseBase upUserInfo(UserInfo user);

    //新增 用户信息
    ResponseBase insertUserInfo(UserInfo user);

    //删除 用户信息
    ResponseBase delUserInfo(List<Integer> uids);

}
