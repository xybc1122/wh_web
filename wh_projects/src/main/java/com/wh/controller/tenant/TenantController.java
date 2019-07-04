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
     * @apiGroup Admin
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
     * 超级管理员创建 存入 租户admin  自己的用户表 跟 租户的用户表
     *
     * @param userInfo
     * @param bindingResult
     * @return
     */
    @PostMapping("/insertTenantAndUser")
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    @RedisLock(key = Constants.SAVE_USER, maxWait = Constants.maxWait, timeout = Constants.timeout)
    public ResponseBase insertTenant(@Valid @RequestBody UserInfo userInfo, BindingResult bindingResult) {
        return tenantService.saveTenantAdmin(userInfo, bindingResult);
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
     * 超级管理员新增 租户的菜单关联
     * @param whUserRole
     * @param bindingResult
     * @return
     */
    @PostMapping("/insertTenantAndMen")
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    public ResponseBase insertTenantAndMen(@Valid @RequestBody WhUserRole whUserRole, BindingResult bindingResult) {
        return tenantService.saveTenantAndMenu(whUserRole, bindingResult);
    }
}
