package com.wh.service.rp.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.mapper.rp.WhUserRolePermsMapper;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.toos.Constants;
import com.wh.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
@Service
public class WhUserRolePermsServiceImpl extends ServiceImpl<WhUserRolePermsMapper, WhUserRolePerms> implements IWhUserRolePermsService {
    @Autowired
    private IWhUserRoleService roleService;

    @Override
    @Transactional
    public ResponseBase serviceSaveRoleAndPerms(WhUserRolePerms rolePerms) {
        if (StringUtils.isBlank(rolePerms.getrName()) || rolePerms.getPerms() == null || rolePerms.getPerms().size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        //先新增角色
        WhUserRole role = new WhUserRole();
        role.setrName(rolePerms.getrName());
        boolean roleResult = roleService.save(role);
        CheckUtils.saveResult(roleResult);
        CheckUtils.saveResult(this.saveBatch(setWhUserRolePerms(rolePerms.getrId(), rolePerms.getPerms())));
        return JsonData.setResultSuccess("success");
    }

    @Override
    @Transactional
    public ResponseBase serviceUpAdnDelRoleAndPerms(WhUserRolePerms rolePerms) {
        if (rolePerms == null || rolePerms.getrId() == null) {
            return JsonData.setResultError("参数is null");
        }
        //1 直接删除已经有的数据
        QueryWrapper<WhUserRolePerms> query = WrapperUtils.getQuery();
        query.eq("r_id", rolePerms.getrId());
        CheckUtils.saveResult(this.remove(query));

        if (rolePerms.getPerms() != null && rolePerms.getPerms().size() > 0) {
            //2 然后  新增新数据
            CheckUtils.saveResult(this.saveBatch(setWhUserRolePerms(rolePerms.getrId(), rolePerms.getPerms())));
        }
        return JsonData.setResultSuccess("success");
    }

    private List<WhUserRolePerms> setWhUserRolePerms(Long rid, List<Integer> perms) {
        List<WhUserRolePerms> rPermsList = new ArrayList<>();
        for (Integer pid : perms) {
            WhUserRolePerms whUserRolePerms = new WhUserRolePerms(rid, pid.longValue());
            whUserRolePerms.setCreate(ReqUtils.getUserName());
            rPermsList.add(whUserRolePerms);
        }
        return rPermsList;
    }

}
