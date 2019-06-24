package com.wh.service.rp;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.rp.WhUserRolePerms;
/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
public interface IWhUserRolePermsService extends IService<WhUserRolePerms> {

    /**
     * 添加角色跟操作权限
     *
     * @return
     */
    ResponseBase serviceSaveRoleAndPerms(WhUserRolePerms whUserRolePerms);

    /**
     * 修改跟删除 角色 配置权限
     *
     * @param rolePerms
     * @return
     */
    ResponseBase serviceUpAdnDelRoleAndPerms(WhUserRolePerms rolePerms);




}
