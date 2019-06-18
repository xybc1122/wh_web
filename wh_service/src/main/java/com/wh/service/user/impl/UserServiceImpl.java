package com.wh.service.user.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.service.user.UserService;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserDto;
import com.wh.entity.user.UserInfo;
import com.wh.mapper.user.UserMapper;
import com.wh.utils.*;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;


    @Autowired
    private IWhUserRoleUserService ruUserService;

    @Override
    public ResponseBase getByUserInfoList(UserDto userDto) {
        PageInfoUtils.setPage(userDto.getPageSize(), userDto.getCurrentPage());
        List<UserInfo> uList = userMapper.selByUserList(userDto);
        return PageInfoUtils.returnPage(mapperFacade.mapAsList(uList, UserDto.class));
    }

    /**
     * 修改用户
     *
     * @return
     */
    @Override
    public ResponseBase upUserInfo(UserInfo user) {
        //这里有问题 修改状态以后不会踢出用户
        if (user.getUserName() != null) {
            return JsonData.setResultError("修改异常 不能修改用户账号");
        }
        Integer version = user.getVersion();
        user.setModify(ReqUtils.getUserName(), version);


        UpdateWrapper<UserInfo> upWrapper = new UpdateWrapper<>();
        upWrapper.eq("uid", user.getUid());
        upWrapper.eq("version", version);

        int i = userMapper.update(user, upWrapper);
        return JsonUtils.saveMsg(i);
    }

    @Override
    @Transactional
    public ResponseBase insertUserInfo(UserInfo user) {
        user.setCreate(ReqUtils.getUserName());
        //新增用户
        int i = userMapper.insert(user);
        CheckUtils.saveResult(i);
        //新增角色
        ruUserService.saveListRole(user.getUid(), user.getRids());
        return JsonData.setResultSuccess("success");
    }

}
