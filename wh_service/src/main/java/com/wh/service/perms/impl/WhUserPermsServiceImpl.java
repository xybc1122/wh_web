package com.wh.service.perms.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserDto;
import com.wh.entity.perms.WhUserPerms;
import com.wh.mapper.perms.WhUserPermsMapper;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-17
 */
@Service
public class WhUserPermsServiceImpl extends ServiceImpl<WhUserPermsMapper, WhUserPerms> implements IWhUserPermsService {

    @Autowired
    private WhUserPermsMapper permsMapper;

    @Override
    public Set<String> serviceGetPermission(String rids,String apiUrl) {
        return permsMapper.getPermission(rids, apiUrl);
    }

    @Override
    public ResponseBase serviceGetPermissionAndOperating(WhUserPerms whUserPerms) {
        PageInfoUtils.setPage(whUserPerms.getPageSize(), whUserPerms.getCurrentPage());
        return PageInfoUtils.returnPage(permsMapper.getPermissionAndOperating(whUserPerms));
    }
}
