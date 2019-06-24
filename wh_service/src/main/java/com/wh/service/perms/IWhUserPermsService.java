package com.wh.service.perms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.perms.WhUserPerms;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-17
 */
public interface IWhUserPermsService extends IService<WhUserPerms> {

    /**
     * 通过角色 api url 去查询对应的 菜单权限
     *
     * @param rids
     * @return
     */
    Set<String> serviceGetPermission(String rids, String apiUrl);


    /**
     * 查询 权限配置组
     *
     * @return
     */
    ResponseBase serviceGetPermissionAndOperating(WhUserPerms whUserPerms);


    /**
     * 删除权限 以及下面的权限操作
     *
     * @return
     */
    ResponseBase serviceDelPermissionAndOperating(List<Integer> pids);
}
