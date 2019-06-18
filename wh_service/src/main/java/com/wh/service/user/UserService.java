package com.wh.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserDto;
import com.wh.entity.user.UserInfo;


public interface UserService extends IService<UserInfo> {


    //查询用户信息
    ResponseBase getByUserInfoList(UserDto userDto);

    //修改用户 跟角色信息
    ResponseBase upUserInfo(UserInfo user);

    //新增 用户信息
    ResponseBase insertUserInfo(UserInfo user);

}
