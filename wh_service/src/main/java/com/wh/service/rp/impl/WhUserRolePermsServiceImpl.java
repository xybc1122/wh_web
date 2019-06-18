package com.wh.service.rp.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.mapper.rp.WhUserRolePermsMapper;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.utils.CheckUtils;
import com.wh.utils.WrapperUtils;
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
    public ResponseBase serviceSaveRoleAndPerms(WhUserRolePerms whUserRolePerms) {
        if (StringUtils.isBlank(whUserRolePerms.getrName()) || whUserRolePerms.getPerms() == null || whUserRolePerms.getPerms().size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        //先新增角色
        WhUserRole role = new WhUserRole();
        role.setrName(whUserRolePerms.getrName());
        boolean roleResult = roleService.save(role);
        CheckUtils.saveResult(roleResult);

        List<WhUserRolePerms> rolePerms = new ArrayList<>();
        for (Integer pid : whUserRolePerms.getPerms()) {
            rolePerms.add(new WhUserRolePerms(role.getRid(), pid.longValue()));
        }

        boolean permResult = this.saveBatch(rolePerms);
        CheckUtils.saveResult(permResult);

        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase serviceDelRoleAndPerms(WhUserRolePerms whUserRolePerms) {
        if (whUserRolePerms.getPerms() == null ||
                whUserRolePerms.getPerms().size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        boolean result = this.removeByIds(whUserRolePerms.getPerms());
        CheckUtils.saveResult(result);
        return JsonData.setResultSuccess("success");
    }
}
