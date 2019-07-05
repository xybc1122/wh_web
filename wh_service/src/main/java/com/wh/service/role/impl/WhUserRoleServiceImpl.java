package com.wh.service.role.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.rm.WhUserRoleMenu;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.service.redis.RedisService;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.mapper.role.WhUserRoleMapper;
import com.wh.entity.role.WhUserRole;


import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.toos.Constants;
import com.wh.utils.CheckUtils;
import com.wh.utils.PageInfoUtils;
import com.wh.utils.ReqUtils;
import com.wh.utils.WrapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
@Service
public class WhUserRoleServiceImpl extends ServiceImpl<WhUserRoleMapper, WhUserRole> implements IWhUserRoleService {

    @Autowired
    private IWhUserRoleMenuService roleMenuService;

    @Autowired
    private WhUserRoleMapper roleMapper;

    @Autowired
    private IWhUserRolePermsService rolePermsService;


    @Autowired
    private IWhUserRoleUserService ruUserService;

    @Autowired
    private RedisService redisService;


    @Override
    public ResponseBase serviceSelRole() {
        return JsonData.setResultSuccess(roleMapper.selRole(ReqUtils.getUid(), ReqUtils.getTid()));
    }

    @Override
    @Transactional
    public ResponseBase serviceSaveRoleAndMenu(WhUserRole whUserRole) {
        if (whUserRole == null || StringUtils.isBlank(whUserRole.getrName())) {
            return JsonData.setResultError("参数 is null");
        }
        //1 新增角色
        whUserRole.setCreate(ReqUtils.getUserName());
        CheckUtils.saveResult(this.save(whUserRole));

        if (whUserRole.getMenus() != null && whUserRole.getMenus().size() > 0) {
            //2 设置角色菜单
            roleMenuService.saveRoleMenu(whUserRole.getRid(), whUserRole.getMenus());
        }
        return JsonData.setResultSuccess("success");
    }

    @Override
    @Transactional
    public ResponseBase serviceUpRoleAndMenu(WhUserRole whUserRole) {
        if (whUserRole == null || whUserRole.getRid() == null || whUserRole.getVersion() == null) {
            return JsonData.setResultError("参数 is null");
        }
        //1先更新 角色名称
        if (StringUtils.isNotBlank(whUserRole.getrName())) {
            Integer version = whUserRole.getVersion();
            UpdateWrapper<WhUserRole> upWrapper = Wrappers.update();
            upWrapper.set("r_name", whUserRole.getrName()).set("modify_user", ReqUtils.getUserName()).
                    set("modify_date", new Date().getTime()).set("version", version + 1).eq("r_id", whUserRole.getRid()).
                    eq("version", version);
            CheckUtils.saveResult(this.update(null, upWrapper));
        }
        //2 删除角色下对应所有的菜单关联
        QueryWrapper<WhUserRoleMenu> rmQuery = WrapperUtils.getQuery();
        rmQuery.eq("r_id", whUserRole.getRid());
        CheckUtils.saveResult(roleMenuService.remove(rmQuery));

        if (whUserRole.getMenus() != null && whUserRole.getMenus().size() > 0) {
            //3 设置新的角色菜单
            roleMenuService.saveRoleMenu(whUserRole.getRid(), whUserRole.getMenus());
        }
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase serviceSelRoleAndPerm(WhUserRole role) {
        PageInfoUtils.setPage(role.getPageSize(), role.getCurrentPage());
        return PageInfoUtils.pageResult(roleMapper.selRoleAndPerm(role, ReqUtils.getRoleId()), null);
    }

    @Override
    @Transactional
    public ResponseBase serviceDleRole(List<Integer> rids) {
        if (rids == null || rids.size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        for (Integer rid : rids) {
            //1 先删除角色信息
            CheckUtils.saveResult(roleMapper.deleteById(rid));
            //2 删除 角色下的权限信息
            QueryWrapper<WhUserRolePerms> rpQuery = WrapperUtils.getQuery();
            rpQuery.eq("r_id", rid);
            CheckUtils.saveResult(rolePermsService.remove(rpQuery));

            //3 删除 角色关联的用户
            QueryWrapper<WhUserRoleUser> ruQuery = WrapperUtils.getQuery();
            ruQuery.eq("r_id", rid);
            CheckUtils.saveResult(ruUserService.remove(ruQuery));

            // 4 删除 角色关联的菜单
            roleMenuService.delRoleMenu(rid.longValue());

        }

        return JsonData.setResultSuccess("success");
    }

    @Override
    public boolean cAdmin(String tenant, String uName, String rids) {
        if (StringUtils.isBlank(rids)) {
            return false;
        }
        String adminKey = RedisService.redisAdminKey(uName, tenant);
        //1 先去redis 拿看看有没有数据
        String strKey = redisService.getStringKey(adminKey);
        //2 如果没有 去数据库查
        if (StringUtils.isBlank(strKey)) {

        }
        return false;
    }

}
