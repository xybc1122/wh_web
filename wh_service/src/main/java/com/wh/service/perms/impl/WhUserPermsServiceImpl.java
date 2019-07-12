package com.wh.service.perms.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.po.WhUserPermsOperating;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.mapper.perms.WhUserPermsMapper;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.service.redis.RedisService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.utils.CheckUtils;
import com.wh.utils.PageInfoUtils;
import com.wh.utils.ReqUtils;
import com.wh.utils.WrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private IWhUserRolePermsService rolePermsService;
    @Autowired
    private IWhUserPermsOperatingService permsOperatingService;
    @Autowired
    private RedisService redisService;

    @Override
    public ResponseBase serviceRoleQueryPermission() {


        return JsonData.setResultSuccess(permsMapper.roleQueryPermission());
    }

    @Override
    public ResponseBase serviceGetPermissionAndOperating(WhUserPerms whUserPerms) {
        PageInfoUtils.setPage(whUserPerms.getPageSize(), whUserPerms.getCurrentPage());
        //


        return PageInfoUtils.pageResult(permsMapper.getPermissionAndOperating(whUserPerms), null);
    }

    @Override
    public Set<String> serviceGetPermission(String rids, String apiUrl) {
        //这里放入缓存

        String permKey = RedisService.redisPermKey(ReqUtils.getUid(), ReqUtils.getTenant());

        Set<String> setRedis = redisService.setMembers(permKey);
        if (setRedis == null || setRedis.size() <= 0) {
            //去数据库查询
            Set<String> setSql = permsMapper.getPermission(rids, apiUrl);
            if (setSql == null) {
                return null;
            }
            for (String str : setSql) {
                redisService.sPush(permKey, str);
            }
            return setSql;
        }
        return setRedis;
    }

    @Override
    public ResponseBase serviceDelPermissionAndOperating(List<Integer> pids) {
        if (pids == null || pids.size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        for (Integer pid : pids) {
            //1 先删除 权限表id
            CheckUtils.saveResult(permsMapper.deleteById(pid));
            //2 删除 权限下面的操作
            QueryWrapper<WhUserPermsOperating> poQuery = WrapperUtils.getQuery();
            poQuery.eq("p_id", pid);
            CheckUtils.saveResult(permsOperatingService.remove(poQuery));
            //3 删除 角色关联的权限
            QueryWrapper<WhUserRolePerms> rQuery = WrapperUtils.getQuery();
            rQuery.eq("p_id", pid);
            CheckUtils.saveResult(rolePermsService.remove(rQuery));
        }
        return JsonData.setResultSuccess("success");
    }
}
