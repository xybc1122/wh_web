package com.wh.service.ur.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.exception.LsException;
import com.wh.mapper.ur.WhUserRoleUserMapper;
import com.wh.service.ur.IWhUserRoleUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户跟角色表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@Service
public class WhUserRoleUserServiceImpl extends ServiceImpl<WhUserRoleUserMapper, WhUserRoleUser> implements IWhUserRoleUserService {


    /**
     * 一个用户 添加多个角色 通用
     *
     * @param uid
     * @param rids
     * @return
     */
    @Override
    public void saveListRole(Long uid, String rids) {
        Collection<WhUserRoleUser> roleUserList = new ArrayList<>();
        WhUserRoleUser whUserRoleUser;
        boolean isResult;
        //新增角色
        if (uid != null && StringUtils.isNotBlank(rids)) {
            //如果是-1说明只增加一个角色
            if (!rids.contains(",")) {
                whUserRoleUser = new WhUserRoleUser(uid, Long.parseLong(rids));
                roleUserList.add(whUserRoleUser);
                isResult = this.saveBatch(roleUserList);
            } else {
                //如果有多个
                String[] rIds = rids.split(",");
                for (String rId : rIds) {
                    whUserRoleUser = new WhUserRoleUser(uid, Long.parseLong(rId));
                    roleUserList.add(whUserRoleUser);
                }
                isResult = this.saveBatch(roleUserList);
            }
            if (!isResult) {
                throw new LsException("添加角色失败");
            }
        }
    }
}
