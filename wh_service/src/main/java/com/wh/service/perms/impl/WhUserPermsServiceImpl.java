package com.wh.service.perms.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.po.WhUserPermsOperating;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.mapper.perms.WhUserPermsMapper;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.utils.CheckUtils;
import com.wh.utils.PageInfoUtils;
import com.wh.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-17
 */
@Service
public class WhUserPermsServiceImpl extends ServiceImpl<WhUserPermsMapper, WhUserPerms> implements IWhUserPermsService {

    @Autowired
    private WhUserPermsMapper permsMapper;

    @Autowired
    private IWhUserRolePermsService rolePermsService;
    @Autowired
    private IWhUserPermsOperatingService permsOperatingService;

    @Override
    public Set<String> serviceGetPermission(String rids, String apiUrl) {
        return permsMapper.getPermission(rids, apiUrl);
    }

    @Override
    public ResponseBase serviceGetPermissionAndOperating(WhUserPerms whUserPerms) {
        PageInfoUtils.setPage(whUserPerms.getPageSize(), whUserPerms.getCurrentPage());
        return PageInfoUtils.returnPage(permsMapper.getPermissionAndOperating(whUserPerms));
    }


    @Override
    public ResponseBase serviceDelPermissionAndOperating(List<Integer> pids) {
        if (pids == null || pids.size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        for (Integer pid : pids) {
            //1 先删除 权限表id
            CheckUtils.saveResult(permsMapper.deleteById(pid));
            //2 删除 权限下面的操作
            QueryWrapper<WhUserPermsOperating> poQuery = WrapperUtils.getQuery();
            poQuery.eq("p_id", pid);
            CheckUtils.saveResult(permsOperatingService.remove(poQuery));
            //3 删除 角色关联的权限
            QueryWrapper<WhUserRolePerms> rQuery = WrapperUtils.getQuery();
            rQuery.eq("p_id", pid);
            CheckUtils.saveResult(rolePermsService.remove(rQuery));
        }
        return JsonData.setResultSuccess("success");
    }
}
