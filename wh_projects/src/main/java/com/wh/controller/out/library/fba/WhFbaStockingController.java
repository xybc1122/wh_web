package com.wh.controller.out.library.fba;


import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.dto.FbaStockingDto;
import com.wh.entity.out.library.fba.WhFbaStocking;
import com.wh.service.out.library.fba.IWhFbaStockingService;
import com.wh.toos.Constants;
import com.wh.utils.PageInfoUtils;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;

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
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase findByFbaAndEntry(@RequestBody WhFbaStocking stocking) {
        List<WhFbaStocking> whFbaStockings = stockingService.serviceSelListWhFbaStocking(stocking);
        //这里转换成DTO
        List<FbaStockingDto> fbaStockingDtoList = mapperFacade.mapAsList(whFbaStockings, FbaStockingDto.class);

        return PageInfoUtils.pageResult(whFbaStockings, fbaStockingDtoList);
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
    @PermissionCheck(type = Constants.SAVE)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
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
    @PermissionCheck(type = Constants.MODIFY)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    public ResponseBase upFbaStocking(@RequestBody WhFbaStocking stocking) {
        return stockingService.serviceUpWhFbaStocking(stocking);
    }


}
