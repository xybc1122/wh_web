package com.wh.service.po.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.dto.DelIdsDto;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.po.WhUserPermsOperating;
import com.wh.mapper.po.WhUserPermsOperatingMapper;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.toos.Constants;
import com.wh.utils.CheckUtils;
import com.wh.utils.ReqUtils;
import com.wh.utils.WrapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
@Service
public class WhUserPermsOperatingServiceImpl extends ServiceImpl<WhUserPermsOperatingMapper, WhUserPermsOperating>
        implements IWhUserPermsOperatingService {
    @Autowired
    private IWhUserPermsService permsService;

    @Override
    @Transactional
    public ResponseBase serviceSavePermsOperating(WhUserPerms userPerms) {
        if (userPerms == null || userPerms.getpName() == null || userPerms.getPermsOperatingList() == null ||
                userPerms.getPermsOperatingList().size() <= 0) {
            return JsonData.setResultError("参数 is null");
        }
        //1 先新增权限
        userPerms.setCreate(ReqUtils.getUserName());
        CheckUtils.saveResult(permsService.save(userPerms));

        //2 新增权限操作
        CheckUtils.saveResult(this.saveBatch(setWhUserPermsOperating(userPerms.getPermsOperatingList(), userPerms.getpId())));
        return JsonData.setResultSuccess("success");
    }

    private List<WhUserPermsOperating> setWhUserPermsOperating(List<WhUserPermsOperating> permsOperatingList, Long pid) {
        List<WhUserPermsOperating> poList = new ArrayList<>();
        //2 新增权限操作
        for (WhUserPermsOperating po : permsOperatingList) {
            po.setpId(pid);
            po.setCreate(ReqUtils.getUserName());
            poList.add(po);
        }
        return poList;
    }

    @Override
    @Transactional
    public ResponseBase serviceUpPermsAndOperating(WhUserPerms userPerms) {
        if (userPerms == null || userPerms.getpId() == null || userPerms.getVersion() == null) {
            return JsonData.setResultError("version / pid  is null");
        }
        //1先更新 权限名称
        if (StringUtils.isNotBlank(userPerms.getpName())) {
            Integer version = userPerms.getVersion();
            UpdateWrapper<WhUserPerms> upWrapper = Wrappers.update();
            upWrapper.set("p_name", userPerms.getpName()).set("modify_user", ReqUtils.getUserName()).
                    set("modify_date", new Date().getTime()).set("version", version + 1).eq("p_id", userPerms.getpId()).
                    eq("version", version);
            CheckUtils.saveResult(permsService.update(null, upWrapper));
        }

        //2先删除 权限 id 下的所有 操作
        QueryWrapper<WhUserPermsOperating> poQuery = WrapperUtils.getQuery();
        poQuery.eq("p_id", userPerms.getpId());
        CheckUtils.saveResult(this.remove(poQuery));
        if (userPerms.getPermsOperatingList() != null && userPerms.getPermsOperatingList().size() > 0) {
            //3 新增权限数据操作
            CheckUtils.saveResult(this.saveBatch(setWhUserPermsOperating(userPerms.getPermsOperatingList(), userPerms.getpId())));
        }
        return JsonData.setResultSuccess("success");
    }
}
