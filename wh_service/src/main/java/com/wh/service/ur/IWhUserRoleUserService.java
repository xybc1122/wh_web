package com.wh.service.ur;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.ur.WhUserRoleUser;

/**
 * <p>
 * 用户跟角色表 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
public interface IWhUserRoleUserService extends IService<WhUserRoleUser> {


    /**
     * 批量新增用户
     */
    void saveListRole(Long uid, String rids);

}
