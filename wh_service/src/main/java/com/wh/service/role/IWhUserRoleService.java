package com.wh.service.role;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.role.WhUserRole;

import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
public interface IWhUserRoleService extends IService<WhUserRole> {


    /**
     * 添加角色  菜单 权限
     *
     * @return
     */
    ResponseBase serviceSaveRoleAndMenu(WhUserRole whUserRole);


    /**
     * 通过角色查询 权限组
     *
     * @return
     */
    ResponseBase serviceSelRoleAndPerm(WhUserRole role);

}
