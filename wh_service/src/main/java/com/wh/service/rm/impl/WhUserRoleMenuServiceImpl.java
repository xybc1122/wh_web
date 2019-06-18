package com.wh.service.rm.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.rm.WhUserRoleMenu;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.exception.LsException;
import com.wh.mapper.rm.WhUserRoleMenuMapper;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 角色菜单权限表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@Service
public class WhUserRoleMenuServiceImpl extends ServiceImpl<WhUserRoleMenuMapper, WhUserRoleMenu> implements IWhUserRoleMenuService {

    @Override
    public ResponseBase setRoleMenu(Long rid, List<Integer> menus) {
        boolean isResult;
        WhUserRoleMenu whUserRoleUser;
        Collection<WhUserRoleMenu> roleMenuList = new ArrayList<>();
        //新增菜单
        if (rid != null && menus != null && menus.size() > 0) {
            //如果是1说明只增加一个菜单
            if (menus.size() == 1) {
                whUserRoleUser = new WhUserRoleMenu(menus.get(0).longValue(), rid);

                whUserRoleUser.setCreate(ReqUtils.getUserName());

                roleMenuList.add(whUserRoleUser);

                isResult = this.saveBatch(roleMenuList);
            } else {
                //如果有多个
                for (Integer mid : menus) {
                    whUserRoleUser = new WhUserRoleMenu(mid.longValue(), rid);

                    whUserRoleUser.setCreate(ReqUtils.getUserName());

                    roleMenuList.add(whUserRoleUser);
                }
                isResult = this.saveBatch(roleMenuList);
            }
            if (!isResult) {
                throw new LsException("配置菜单失败");
            }
            return JsonData.setResultSuccess("success");
        }
        throw new LsException("参数 is null");
    }


    @Override
    public ResponseBase delRoleMenu(List<Integer> rmIds) {
        return null;
    }
}
