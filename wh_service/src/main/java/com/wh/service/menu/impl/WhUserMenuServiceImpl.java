package com.wh.service.menu.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.entity.dto.TreeDto;
import com.wh.entity.menu.WhUserMenu;
import com.wh.entity.parent.ParentTree;
import com.wh.mapper.menu.WhUserMenuMapper;
import com.wh.service.menu.IWhUserMenuService;
import com.wh.store.TreeStructureStore;
import com.wh.toos.Constants;
import com.wh.utils.ReqUtils;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@Service
public class WhUserMenuServiceImpl extends ServiceImpl<WhUserMenuMapper, WhUserMenu> implements IWhUserMenuService {
    @Autowired
    private WhUserMenuMapper menuMapper;

    @Override
    public ResponseBase serviceSelTreeList() {
        return JsonData.setResultSuccess(TreeStructureStore.getTree(menuMapper.selTreeList()));
    }

}
