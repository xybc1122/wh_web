package com.wh.controller.out_library.fba;


import com.wh.base.ResponseBase;
import com.wh.service.out_library.fba.IWhFbaStockingEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/api/v1/wh-fba-stocking-entry")
public class WhFbaStockingEntryController {
    @Autowired
    private IWhFbaStockingEntryService entryService;


    /**
     * @api {PUT} api/v1/wh-fba-stocking-entry/upOrDelFbaStockingEntry 修改/删除 fba备货装箱信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup 出库
     * @apiVersion 0.0.1
     * @apiParam {List} delIds 传要删除的id集合
     * @apiParam {List} stockingEntry 传需要更新的List对象集合
     * @apiDescription 用于修改/删除 fba备货装箱信息
     * @apiParamExample {json} 请求样例：
     * {
     * "delIds":[1,2,3],
     * "stockingEntry":[{"fnSku":"测试","id":4,"version":0 必须填},{"fnSku":"策划","id":5,"version":0}]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upOrDelFbaStockingEntry")
    public ResponseBase upFbaStocking(@RequestBody Map<String, Object> objectMap) {
        return entryService.upOrWhFbaStockingEntry(objectMap);
    }


}
