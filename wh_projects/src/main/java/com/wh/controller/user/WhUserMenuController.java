package com.wh.controller.user;


import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.menu.IWhUserMenuService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@RestController
@RequestMapping("/api/v1/wh-menu")
public class WhUserMenuController {


    @Autowired
    private IWhUserMenuService menuService;

    /**
     * 通过角色查询菜单信息
     *
     * @return
     */
    @GetMapping("/findByListMenu")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase findByListWar() {
        return menuService.serviceSelTreeList();

    }


}
