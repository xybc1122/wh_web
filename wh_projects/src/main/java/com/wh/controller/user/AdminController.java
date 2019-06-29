package com.wh.controller.user;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.DelIdsDto;
import com.wh.entity.dto.UserDto;
import com.wh.entity.perms.WhUserPerms;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.rp.WhUserRolePerms;
import com.wh.entity.user.UserInfo;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.service.po.IWhUserPermsOperatingService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.rp.IWhUserRolePermsService;
import com.wh.service.ur.IWhUserRoleUserService;
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
    private IWhUserRoleUserService ruService;


    @Autowired
    private IWhUserRoleService roleService;


    @Autowired
    private IWhUserPermsService permsService;

    @Autowired
    private IWhUserRolePermsService rolePermsService;

    @Autowired
    private IWhUserPermsOperatingService permsOperatingService;

    /**
     * @api {POST} api/v1/admin/getByUserInfoList 查询用户信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于查询用户信息
     * @apiParam {String} [name] 名称
     * @apiParam {String} [rName] 角色名称
     * @apiParam {Integer} [accountStatus] 状态信息
     * @apiParam {List} [createDates] 创建时间
     * @apiParamExample {json} 请求样例：
     * {
     * "name":"陈恩惠",
     * "userName":"tt",
     * "accountStatus":0,
     * "rName":"超级管理员",
     * "createDates":[11111,111111]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getByUserInfoList")
    public ResponseBase getByUserInfoList(@RequestBody UserDto userDto) {
        return userService.getByUserInfoList(userDto);
    }


    /**
     * @api {PUT} api/v1/admin/upUserInfo 修改用户信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于更新用户信息
     * @apiParam {Integer} uid 更新id
     * @apiParam {Integer} version 更新版本号
     * @apiParamExample {json} 请求样例：
     * {
     * "uid":1,
     * "version":10
     * xxxx  其余的修改对象   userName 是不给更新的不能传过来
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upUserInfo")
    public ResponseBase upUserInfo(@RequestBody UserInfo userInfo) {
        return userService.upUserInfo(userInfo);
    }


    /**
     * @api {PUT} api/v1/admin/upUserAndRole 修改用户下面的角色信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于修改用户下面的角色信息
     * @apiParam {Integer} uid 更新id
     * @apiParam {String} rids 角色 ids
     * @apiParamExample {json} 请求样例：
     * {
     * "uid":1,
     * "rids":"1,2,3"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upUserAndRole")
    public ResponseBase upUserAndRole(@RequestBody UserInfo user) {
        return ruService.upUserAndRole(user);
    }

    /**
     * @api {Delete} api/v1/admin/delUserInfo 逻辑删除 用户/角色信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 通过用户id删除下面的角色信息
     * @apiParam {List} idDelList 删除的 用户 id
     * @apiParamExample {json} 请求样例：
     * {
     * "idDelList":[1,2,3,4,5,n]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @DeleteMapping("/delUserAndRole")
    public ResponseBase delUserAndRole(@RequestBody DelIdsDto delIdsDto) {
        return userService.delUserInfo(delIdsDto.getIdDelList());
    }


    /**
     * @api {Post} api/v1/admin/insertUserInfo 新增用户信息以及下面的角色信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于新增用户信息以及下面的角色信息
     * @apiParam {String} userName 用户名
     * @apiParam {String} pwd 密码
     * @apiParam {String} rids 需要添加的角色 rdis
     * @apiParamExample {json} 请求样例：
     * {
     * "userName":"eeee",
     * "pwd":"123456",
     * "rids":"7,8,9,10"
     * xxxxx 一些页面可以添加的数据
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertUserInfo")
    public ResponseBase insertUserInfo(@RequestBody UserInfo userInfo) {
        return userService.insertUserInfo(userInfo);
    }


    /**
     * @api {get} api/v1/admin/getByRoleList 查询所有角色信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于获得所有角色信息
     * @apiParamExample {json} 请求样例：
     * {
     * 不需要参数
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @GetMapping("/getByRoleList")
    public ResponseBase getByRoleList() {
        return JsonData.setResultSuccess(roleService.list());
    }


    /**
     * @api {Delete} api/v1/admin/dleRole 逻辑删除 角色/关联权限/关联用户/关联的菜单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 通过角色id 去删除
     * @apiParam {List} idDelList 删除的 角色 id
     * @apiParamExample {json} 请求样例：
     * {
     * "idDelList":[1,2,3,4,5,n]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @DeleteMapping("/dleRole")
    public ResponseBase dleRole(@RequestBody DelIdsDto delIdsDto) {
        return roleService.serviceDleRole(delIdsDto.getIdDelList());
    }


    /**
     * @api {POST} api/v1/admin/saveRoleAndMenu 新增角色跟菜单查看权限
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于新增角色跟菜单查看权限
     * @apiParam {String} rName 角色 名称
     * @apiParam {List} menus 菜单 id 集合
     * @apiParamExample {json} 请求样例：
     * {
     * "rName":1,
     * "menus":[6,9,0,9,10]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/saveRoleAndMenu")
    public ResponseBase saveRoleAndMenu(@RequestBody WhUserRole role) {
        return roleService.serviceSaveRoleAndMenu(role);
    }

    /**
     * @api {PUT} api/v1/admin/saveRoleAndMenu 修改角色/菜单查看权限
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用角色id 去修改菜单信息
     * @apiParam {Integer} rId 角色名称
     * @apiParam {version} version 版本 注 如果你想修改角色名称 必须传版本信息
     * @apiParam {String} rName 角色id
     * @apiParam {List} menus 菜单 id 集合
     * @apiParamExample {json} 请求样例：
     * {
     * "rid":10,
     * "rName":"测试",
     * "version":0,
     * "menus":[7,8,9]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upRoleAndMenu")
    public ResponseBase upRoleAndMenu(@RequestBody WhUserRole role) {
        return roleService.serviceUpRoleAndMenu(role);
    }


    /**
     * @api {POST} api/v1/admin/saveRoleAndPerms 新增角色跟权限
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于新增角色跟权限
     * @apiParam {String} rName 角色 名称
     * @apiParam {List} perms 权限 id 集合
     * @apiParamExample {json} 请求样例：
     * {
     * "rName":"仓库",
     * "perms":[1,2,34]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/saveRoleAndPerms")
    public ResponseBase saveRoleAndPerms(@RequestBody WhUserRolePerms rolePerms) {
        return rolePermsService.serviceSaveRoleAndPerms(rolePerms);
    }


    /**
     * @api {PUT} api/v1/admin/upAndDelRoleAndPerms 修改角色配置权限
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于角色配置权限修改跟删除
     * @apiParam {Integer} rId 角色 id
     * @apiParam {List} perms 权限 id 集合
     * @apiParamExample {json} 请求样例：
     * {
     * "rId":2,
     * "perms":[1,4,6,10]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upAndDelRoleAndPerms")
    public ResponseBase upAdnDelRoleAndPerms(@RequestBody WhUserRolePerms rolePerms) {
        return rolePermsService.serviceUpAdnDelRoleAndPerms(rolePerms);
    }


    /**
     * @api {POST} api/v1/admin/getPermissionAndOperating 查询权限组里面的操作信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于查询权限组里面的操作信息
     * @apiParamExample {json} 请求样例：
     * {
     * 传空对象 这里还没有设置条件查询
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getPermissionAndOperating")
    public ResponseBase getPermissionAndOperating(@RequestBody WhUserPerms whUserPerms) {
        return permsService.serviceGetPermissionAndOperating(whUserPerms);
    }

    /**
     * @api {POST} api/v1/admin/getRoleAndPerm 查询角色对应的权限
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于查询角色对应的权限
     * @apiParamExample {json} 请求样例：
     * {
     * 传空对象 这里还没有设置条件查询
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getRoleAndPerm")
    public ResponseBase getRoleAndPerm(@RequestBody WhUserRole role) {
        return roleService.serviceSelRoleAndPerm(role);
    }


    /**
     * @api {GET} api/v1/admin/getPermission 查询权限列表
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于权限列表
     * @apiParamExample {json} 请求样例：
     * {
     * 不需要参数
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @GetMapping("/getPermission")
    public ResponseBase getPermission() {
        return JsonData.setResultSuccess(permsService.lambdaQuery().select(WhUserPerms::getpId, WhUserPerms::getpName).list());
    }


    /**
     * @api {Delete} api/v1/admin/delPermsAndOperating 逻辑删除 权限/关联的权限操作/关联的角色
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 通过权限id去删除
     * @apiParam {List} idDelList 删除的 权限 id
     * @apiParamExample {json} 请求样例：
     * {
     * "idDelList":[1,2,3,4,5,n]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @DeleteMapping("/delPermsAndOperating")
    public ResponseBase dlePermsAndOperating(@RequestBody DelIdsDto delIdsDto) {
        return permsService.serviceDelPermissionAndOperating(delIdsDto.getIdDelList());
    }

    /**
     * @api {POST} api/v1/admin/savePermissionOperating 新增操作权限下面的 增删改信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {Integer} pId 权限id
     * @apiParam {String} apiUrl 对应的请求url
     * @apiParam {String} poName 对应的请求方式
     * @apiDescription 用于新增操作权限下面的 增删改信息
     * @apiParamExample {json} 请求样例：
     * {"pName":"查看",
     * "permsOperatingList":[{"apiUrl":"/index/api","poName":"GET"},{"apiUrl":"/index/api1","poName":"POST"}]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/savePermissionOperating")
    public ResponseBase savePermissionOperating(@RequestBody WhUserPerms userPerms) {
        return permsOperatingService.serviceSavePermsOperating(userPerms);
    }


    /**
     * @api {POST} api/v1/admin/upPermsAndOperating 修改权限下面的权限操作信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {Integer} pId 权限id
     * @apiParam {String} pName 修改的权限名称
     * @apiParam {Integer} version 版本  注 如果要修改权限名称 必须传版本
     * @apiParam {String} apiUrl 对应的请求url
     * @apiParam {String} poName 对应的请求方式
     * @apiDescription 用于修改权限下面的权限操作信息
     * @apiParamExample {json} 请求样例：
     * {"pId":9,
     * "pName":"测试",
     * "version":10,
     * "permsOperatingList":[{"apiUrl":"/index/api","poName":"GET"},{"apiUrl":"/index/api1","poName":"POST"}]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upPermsAndOperating")
    public ResponseBase upPermsAndOperating(@RequestBody WhUserPerms whUserPerms) {
        return permsOperatingService.serviceUpPermsAndOperating(whUserPerms);
    }

}
