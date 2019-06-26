package com.wh.service.user.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.customize.RedisLock;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.service.user.UserService;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserDto;
import com.wh.entity.user.UserInfo;
import com.wh.mapper.user.UserMapper;
import com.wh.toos.Constants;
import com.wh.utils.*;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;
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
        if (user.getAccountStatus() != null && user.getAccountStatus() == 1) {
            //踢出redis key 停用
            redisUtils.delKey(Constants.SSO_TOKEN + ":" + user.getUid());
        }
        Integer version = user.getVersion();
        user.setModify(ReqUtils.getUserName(), version);


        UpdateWrapper<UserInfo> upWrapper = new UpdateWrapper<>();
        upWrapper.eq("uid", user.getUid()).eq("version", version);


        int i = userMapper.update(user, upWrapper);


        return JsonUtils.saveMsg(i);
    }

    @Override
    @RedisLock(key = Constants.SAVE_USER_ROLE, maxWait = Constants.maxWait, timeout = Constants.timeout)
    @Transactional
    public ResponseBase insertUserInfo(UserInfo user) {
        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPwd())) {
            return JsonData.setResultError("用户名/密码不能为空");
        }
        //到这里先去查查看有没有名字相同的
        if (userMapper.selUserIsDelete(user.getUserName()) != null) {
            return JsonData.setResultError("添加名字重复");
        }
        user.setPwd(MD5Util.saltMd5(user.getUserName(), user.getPwd()));
        user.setCreate(ReqUtils.getUserName());
        //新增用户
        CheckUtils.saveResult(userMapper.insert(user));
        //新增角色
        ruUserService.saveListRole(user.getUid(), user.getRids());
        return JsonData.setResultSuccess("success");
    }

    @Override
    @Transactional
    public ResponseBase delUserInfo(List<Integer> uids) {
        if (uids == null || uids.size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        for (Integer uid : uids) {
            //1先删除用户
            CheckUtils.saveResult(userMapper.deleteById(uid));
            //2 删除用户下面的角色
            QueryWrapper<WhUserRoleUser> query = WrapperUtils.getQuery();
            query.eq("u_id", uid);
            CheckUtils.saveResult(ruUserService.remove(query));
        }

        return JsonData.setResultSuccess("success");
    }

}
