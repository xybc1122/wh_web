package com.wh.controller.fba;


import com.wh.base.ResponseBase;
import com.wh.entity.fba.WhFbaStocking;
import com.wh.service.fba.IWhFbaStockingService;
import com.wh.service.fba.impl.WhFbaStockingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @apiGroup 出库
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
     * @api {PUT} api/v1/wh-fba-stocking/upFbaStocking 修改fba备货信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup 出库
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
