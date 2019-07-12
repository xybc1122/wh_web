package com.wh.controller.out.library.transfer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.out.library.transfer.WhTransferOutLibrary;
import com.wh.service.out.library.transfer.IWhTransferOutLibraryEntryService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName WhTransferOutLibraryEntryController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/10 10:30
 **/
@RestController
@RequestMapping("/api/v1/wh-tra-library-entry")
public class WhTransferOutLibraryEntryController {
    @Autowired
    private IWhTransferOutLibraryEntryService entryService;

    /**
     * @api {POST} api/v1/wh-tra-library-entry/upTransfer 更新调拨出库
     * @apiHeaderExample {json} 请求头Header
     * {
     * "sso-token":"用户令牌"
     * }
     * @apiGroup Transfer
     * @apiParam {String} tNumber 更新单号
     * @apiParam {Integer} version 版本
     * @apiVersion 0.0.1
     * @apiDescription 用于更新标记发货
     * @apiParamExample {json} 请求样例：
     * {
     * "tNumber":"DB6544000455125499904",
     * "version":0 必传
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PutMapping("/upTransferEntry")
    @PermissionCheck(type = Constants.MODIFY)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @HystrixCommand(fallbackMethod = "upTransferEntryHystrix")
    public ResponseBase upTransferEntry(@RequestBody Map<String, Object> objectMap) {
        return entryService.serviceUpOutLibrary(objectMap);
    }

    //注意，方法签名一定要要和api方法一致  熔断
    private ResponseBase upTransferEntryHystrix(Map<String, Object> objectMap) {

        System.out.println("这里可以配置 redis 发送短信 异常报警");

        return JsonData.setResultError("调用php接口 失败");
    }

}
