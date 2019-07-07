package com.wh.service.role;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.role.WhUserRole;

import java.util.List;
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
     * 通过用户关联id 查询角色信息
     */
    ResponseBase serviceSelRole();

    /**
     * 添加角色 /菜单查看权限
     *
     * @return
     */
    ResponseBase serviceSaveRoleAndMenu(WhUserRole whUserRole);

    /**
     * 修改角色 /菜单查看权限
     *
     * @return
     */
    ResponseBase serviceUpRoleAndMenu(WhUserRole whUserRole);


    /**
     * 通过角色查询 权限组
     *
     * @return
     */
    ResponseBase serviceSelRoleAndPerm(WhUserRole role);


    /**
     * 通过角色 删除以及下面的权限组
     *
     * @return
     */
    ResponseBase serviceDleRole(List<Integer> rids);

    /**
     * 判断是否是admin
     *
     * @param tenant
     * @param uName
     * @param rids
     * @return
     */
    boolean cAdmin(String tenant, String uName, String rids);
}
