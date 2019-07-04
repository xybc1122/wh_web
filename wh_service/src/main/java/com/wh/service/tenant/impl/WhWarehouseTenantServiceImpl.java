package com.wh.service.tenant.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.dds.DynamicDataSourceContextHolder;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.user.UserInfo;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.mapper.tenant.WhWarehouseTenantMapper;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.service.user.UserService;
import com.wh.store.BindingResultStore;
import com.wh.utils.CheckUtils;
import com.wh.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
@Service
public class WhWarehouseTenantServiceImpl extends ServiceImpl<WhWarehouseTenantMapper, WhWarehouseTenant> implements IWhWarehouseTenantService {
    @Autowired
    private UserService userService;

    @Autowired
    private IWhUserRoleService roleService;

    @Autowired
    private IWhUserRoleMenuService roleMenuService;

    private static String URL = "jdbc:mysql://%s?useUnicode=true&nullCatalogMeansCurrent=true&characterEncoding=utf-8&useSSL=false";


    @Override
    public ResponseBase selTenantRole(Integer tId) {
        //1 通过 tid 查询租户
        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
        tQuery.eq("tenant_id", tId);
        WhWarehouseTenant tOne = this.getOne(tQuery);
        //2切换租户
        DynamicDataSourceContextHolder.setDataSourceKey(tOne.getTenant());
        //3 查询角色信息返回

        return JsonData.setResultSuccess(roleService.list());
    }

    @Override
    public ResponseBase saveTenant(WhWarehouseTenant tenant, BindingResult bindingResult) {
        //1校验参数
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);
        //2这里先查询 是否已有这个租户标识 不能重复
        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
        tQuery.select("tenant_id").eq("tenant", tenant.getTenant());
        WhWarehouseTenant tOne = this.getOne(tQuery);
        if (tOne != null) {
            return JsonData.setResultSuccess("租户标识重复");
        }
        String url = String.format(URL, tenant.getDbUrl());
        tenant.setDbUrl(url);
        //3 创建租户信息
        CheckUtils.saveResult(this.save(tenant));

        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase saveTenantAdmin(UserInfo user, BindingResult bindingResult) {
        //这里有分布式事物问题
        String result;
        //1 先新增用户
        result = userService.insertUserInfoAndTenant(user, bindingResult);
        if (result != null) {
            return JsonData.setResultError(result);
        }
        //2 切换数据源 新增 租户表表里的数据

        DynamicDataSourceContextHolder.setDataSourceKey(user.getTenant());

        result = userService.insertUserInfoAndTenant(user, bindingResult);
        if (result != null) {
            return JsonData.setResultError(result);
        }

        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase saveTenantAndMenu(WhUserRole whUserRole, BindingResult bindingResult) {
        String strBinding = BindingResultStore.bindingResult(bindingResult);
        if (strBinding != null) return JsonData.setResultError(strBinding);

        if (whUserRole.gettId() == null) {
            return JsonData.setResultError("tid is null");
        }
        //1 通过 tid 查询租户
        QueryWrapper<WhWarehouseTenant> tQuery = WrapperUtils.getQuery();
        tQuery.eq("tenant_id", whUserRole.gettId());
        WhWarehouseTenant tOne = this.getOne(tQuery);
        //2切换租户
        DynamicDataSourceContextHolder.setDataSourceKey(tOne.getTenant());
        //2 设置角色菜单
        roleMenuService.saveTenantRoleMenu(whUserRole.getRid(), whUserRole.getMenus(), whUserRole.gettId());

        return JsonData.setResultSuccess("success");
    }


    public static void main(String[] args) {
        System.out.println(String.format(URL, "192.168.1.230:3306/db2"));
    }
}
