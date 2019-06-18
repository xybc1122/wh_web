package com.wh.controller.user;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.entity.dto.UserDto;
import com.wh.entity.meun.WhUserMenu;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.po.WhUserPermsOperating;
import com.wh.entity.rm.WhUserRoleMenu;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.entity.user.UserInfo;
import com.wh.service.menu.IWhUserMenuService;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/14 10:36
 **/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private IWhUserRoleService roleService;

    @Autowired
    private IWhUserRoleMenuService roleMenuService;

    @Autowired
    private IWhUserMenuService menuService;

    @Autowired
    private IWhUserPermsService permsService;

    @Autowired
    private IWhUserRolePermsService rolePermsService;

    @Autowired
    private IWhUserPermsOperatingService permsOperatingService;

    /**
     * 获得所有用户信息
     *
     * @return
     */
    @PermissionCheck("GET")
    @PostMapping("/getByUserInfoList")
    public ResponseBase getByUserInfoList(@RequestBody UserDto userDto) {
        return userService.getByUserInfoList(userDto);
    }

    /**
     * 修改用户信息跟角色信息
     *
     * @return
     */
    @PutMapping("/upUserInfo")
    public ResponseBase upUserAndRole(@RequestBody UserInfo userInfo) {
        return userService.upUserInfo(userInfo);
    }


    /**
     * 新增用户信息
     *
     * @return
     */
    @PostMapping("/insertUserInfo")
    public ResponseBase insertUserInfo(@RequestBody UserInfo userInfo) {
        return userService.insertUserInfo(userInfo);
    }


    /**
     * 获得所有角色信息
     *
     * @return
     */
    @GetMapping("/getByRoleList")
    public ResponseBase getByRoleList() {
        return JsonData.setResultSuccess(roleService.list());
    }


    /**
     * 设置角色跟菜单的权限
     *
     * @return
     */
    @PostMapping("/saveRoleMenu")
    public ResponseBase saveRoleMenu(@RequestBody WhUserRoleMenu roleMenu) {
        return roleMenuService.setRoleMenu(roleMenu.getRid(), roleMenu.getMenus());
    }

    /**
     * 查看菜单对应的权限
     *
     * @return
     */
    @PostMapping("/getMenuPerms")
    public ResponseBase getMenuPerms(@RequestBody WhUserMenu menu) {
        return menuService.serviceSelMenuPerms(menu);
    }


    /**
     * 添加角色跟菜单查看权限
     */
    @PostMapping("/saveRoleAndMenu")
    public ResponseBase saveRoleAndMenu(@RequestBody WhUserRole role) {
        return roleService.serviceSaveRoleAndMenu(role);
    }

    /**
     * 添加角色跟操作权限
     */
    @PostMapping("/saveRoleAndPerms")
    public ResponseBase saveRoleAndPerms(@RequestBody WhUserRolePerms rolePerms) {
        return rolePermsService.serviceSaveRoleAndPerms(rolePerms);
    }

    /**
     * 移除角色对应的操作权限
     */
    @DeleteMapping("/delRoleAndPerms")
    public ResponseBase delRoleAndPerms(@RequestBody WhUserRolePerms rolePerms) {
        return rolePermsService.serviceDelRoleAndPerms(rolePerms);
    }

    /**
     * 查询权限组 里面的操作信息
     */
    @PostMapping("/getPermissionAndOperating")
    public ResponseBase getPermissionAndOperating(@RequestBody WhUserPerms whUserPerms) {
        return permsService.serviceGetPermissionAndOperating(whUserPerms);
    }

    /**
     * 查询角色对应的权限
     */
    @PostMapping("/getRoleAndPerm")
    public ResponseBase getUserAndRole(@RequestBody WhUserRole role) {

        return roleService.serviceSelRoleAndPerm(role);
    }


    /**
     * 获得权限列表
     */
    @GetMapping("/getPermission")
    public ResponseBase getPermission() {
        return JsonData.setResultSuccess(permsService.lambdaQuery().select(WhUserPerms::getpId, WhUserPerms::getpName).list());
    }

    /**
     * 添加操作权限下面的 增删改信息
     */
    @PostMapping("/savePermissionOperating")
    public ResponseBase savePermissionOperating(@RequestBody WhUserPermsOperating permsOperating) {
        return permsOperatingService.serviceSavePermsOperating(permsOperating);
    }

}
