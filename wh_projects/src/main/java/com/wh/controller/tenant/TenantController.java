package com.wh.controller.tenant;

import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.customize.RedisLock;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.tenant.WhWarehouseTenant;
import com.wh.entity.user.UserInfo;
import com.wh.service.tenant.IWhWarehouseTenantService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName TenantController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/4 13:15
 **/
@RestController
@RequestMapping("/api/v1/super-admin")
public class TenantController {

    @Autowired
    private IWhWarehouseTenantService tenantService;


    /**
     * @api {Post} api/v1/super-admin/insertTenant 新增创建租户信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于新增用户信息以及下面的角色信息
     * @apiParamExample {json} 请求样例：
     * {
     * "dbPwd":"root",
     * "tenantName":"浙江创业3",
     * "dbName":"root",
     * "dbUrl":"192.168.1.230:3306/db3",
     * "tenant":"tenant3"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenant")
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    @RedisLock(key = Constants.SAVE_TENANT, maxWait = Constants.maxWait, timeout = Constants.timeout)
    public ResponseBase insertTenant(@Valid @RequestBody WhWarehouseTenant tenant, BindingResult bindingResult) {
        return tenantService.saveTenant(tenant, bindingResult);
    }

    /**
     * @api {Post} api/v1/super-admin/insertTenantAndUser 超级管理员创建新增租户admin自己的用户表 跟 租户的用户表
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员创建新增租户admin自己的用户表 跟 租户的用户表
     * @apiParamExample {json} 请求样例：
     * {
     * "pwd":"123456",
     * "userName":"admin1",
     * "tId":1,
     * "tenant":"tenant1"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenantAndUser")
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    @RedisLock(key = Constants.SAVE_USER, maxWait = Constants.maxWait, timeout = Constants.timeout)
    public ResponseBase insertTenant(@Valid @RequestBody UserInfo userInfo, BindingResult bindingResult) {
        return tenantService.saveTenantAdmin(userInfo, bindingResult);
    }

    /**
     * 超级管理员查询租户表里的超级管理员 菜单信息
     */
    @GetMapping("/selTenantMenu")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase selTenantMenu(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantMenu(tid);
    }


    /**
     * 超级管理员查询租户表里的超级管理员 角色信息
     */
    @GetMapping("/selTenantRole")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase selTenantRole(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantRole(tid);
    }


    /**
     * @api {Post} api/v1/super-admin/insertTenantAndMen 超级管理员新增租户的菜单关联
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员新增租户的菜单关联
     * @apiParamExample {json} 请求样例：
     * {
     * "rid":1,
     * "menus":[10,11,12,13,14,15,16,17,18],
     * "tId":1
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/insertTenantAndMen")
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    public ResponseBase insertTenantAndMen(@Valid @RequestBody WhUserRole whUserRole, BindingResult bindingResult) {
        return tenantService.saveTenantAndMenu(whUserRole, bindingResult);
    }


    /**
     * @api {GET} /api/v1/super-admin/selTenantPermission 超级管理员查询租户权限列表进行配置
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup super-admin
     * @apiVersion 0.0.1
     * @apiDescription 用于超级管理员查询租户权限列表进行配置
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @GetMapping("/selTenantPermission")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase tenantPermission(@RequestParam("tid") Integer tid) {
        return tenantService.selTenantPermission(tid);
    }


}
