package com.wh.service.role.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.mapper.role.WhUserRoleMapper;
import com.wh.entity.role.WhUserRole;


import com.wh.utils.CheckUtils;
import com.wh.utils.PageInfoUtils;
import com.wh.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public ResponseBase serviceSaveRoleAndMenu(WhUserRole whUserRole) {
        if (whUserRole == null || StringUtils.isBlank(whUserRole.getrName())) {
            return JsonData.setResultError("参数 is null");
        }
        //1 新增角色
        whUserRole.setCreate(ReqUtils.getUserName());
        boolean result = this.save(whUserRole);
        CheckUtils.saveResult(result);

        if (whUserRole.getMenus() != null && whUserRole.getMenus().size() > 0) {
            //2 配置角色菜单
            roleMenuService.setRoleMenu(whUserRole.getRid(), whUserRole.getMenus());
        }
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase serviceSelRoleAndPerm(WhUserRole role) {
        PageInfoUtils.setPage(role.getPageSize(), role.getCurrentPage());
        return PageInfoUtils.returnPage(roleMapper.selRoleAndPerm(role));
    }
}
