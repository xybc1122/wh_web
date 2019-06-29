package com.wh.controller.out_library.fba;


import com.wh.base.ResponseBase;
import com.wh.entity.out_library.fba.WhFbaStocking;
import com.wh.service.out_library.fba.IWhFbaStockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * fba备货
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/api/v1/wh-fba-stocking")
public class WhFbaStockingController {

    @Autowired
    private IWhFbaStockingService stockingService;


    /**
     * @api {POST} api/v1/wh-fba-stocking/findByFbaAndEntry 查询fba备货信息和箱号信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup FBA Stocking
     * @apiVersion 0.0.1
     * @apiDescription 用于查询fba备货信息 And 箱号信息
     * @apiParamExample {json} 请求样例：
     * {
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/findByFbaAndEntry")
    public ResponseBase findByFbaAndEntry(@RequestBody WhFbaStocking stocking) {
        return stockingService.serviceSelListWhFbaStocking(stocking);
    }

    /**
     * @api {POST} api/v1/wh-fba-stocking/saveFbaAndEntry 新增fba备货信息和箱号信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup FBA Stocking
     * @apiParam {String} sku sku
     * @apiParam {String} site 站点
     * @apiParam {String} shipMethods 物流方式/跟踪号
     * @apiParam {String} dInformation 收货信息
     * @apiParam {Integer} quantity 数量
     * @apiParam {String} account 账号
     * @apiParam {Integer} nOfBoxes 包装箱数量
     * @apiVersion 0.0.1
     * @apiDescription 用于新增fba备货信息和箱号信息
     * @apiParamExample {json} 请求样例：
     * {"entry":[{
     * "fnSku":"1122KK",
     * "fseName":"测试name",
     * "quantity":80,
     * "sku":"cccccc"
     * },{
     * "fnSku":"1122K2",
     * "fseName":"测试name2",
     * "quantity":802,
     * "sku":"cccccc2"
     * }],
     * "site":"UA",
     * "shipMethods":"测试",
     * "dInformation":"测试1",
     * "account":"cc",
     * "nOfBoxes":5
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/saveFbaAndEntry")
    public ResponseBase saveFbaAndEntry(@Valid @RequestBody WhFbaStocking stocking, BindingResult result) {
        return stockingService.serviceSaveWhFbaStocking(stocking, result);
    }

    /**
     * @api {PUT} api/v1/wh-fba-stocking/upFbaStocking 修改fba备货信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup FBA Stocking
     * @apiVersion 0.0.1
     * @apiParam {Integer} id 更新id
     * @apiParam {Integer} version 更新版本
     * @apiDescription 用于修改fba备货信息
     * @apiParamExample {json} 请求样例：
     * {
     * "id":1, 必须有
     * "version":0, 必须有
     * "aNumber":"修改测试"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upFbaStocking")
    public ResponseBase upFbaStocking(@RequestBody WhFbaStocking stocking) {
        return stockingService.serviceUpWhFbaStocking(stocking);
    }

}
