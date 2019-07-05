package com.wh.controller.out.library.transfer;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.customize.RedisLock;
import com.wh.entity.out.library.transfer.WhTransferOutLibrary;
import com.wh.service.out.library.transfer.IWhTransferOutLibraryService;
import com.wh.toos.Constants;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
@RestController
@RequestMapping("/api/v1/wh-transfer-out-library")
public class WhTransferOutLibraryController {


    @Autowired
    private IWhTransferOutLibraryService outLibraryService;


    /**
     * @api {POST} api/v1/wh-transfer-out-library/findByTransferInfo 查询调拨出库跟条目
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Transfer
     * @apiVersion 0.0.1
     * @apiDescription 用于查询调拨出库跟条目
     * @apiParamExample {json} 请求样例：
     * {
     * "tNumber": "DB6543380444191129600"
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/findByTransferInfo")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase findByTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return PageInfoUtils.pageResult(outLibraryService.serviceSelOutLibraryInfo(outLibrary), null);
    }


    /**
     * @api {POST} api/v1/wh-transfer-out-library/delTransferInfo 删除调拨出库跟条目
     * @apiHeaderExample {json} 请求头Header
     * {
     * "sso-token":"用户令牌"
     * }
     * @apiGroup Transfer
     * @apiParam {String} tNumber 主表单 id
     * @apiParam {List} eIds 子表单集合
     * @apiVersion 0.0.1
     * @apiDescription 用于删除调拨出库跟条目
     * @apiParamExample {json} 请求样例：
     * {"tNumber":"DB6543380444191129600",
     * "eIds":[1,2,3,4]
     * 注: 如果你只传一个tNumber 这里会帮你你全部删除以及下面字表信息
     * 如果你传了tNumber 跟 eIds[] 只会删除 字表里面的数据
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @DeleteMapping("/delTransferInfo")
    @PermissionCheck(type = Constants.DELETE)
    public ResponseBase delTransferInfo(@RequestBody Map<String, Object> objectMap) {
        return outLibraryService.serviceDelOutLibraryInfo(objectMap);
    }


    /**
     * @api {POST} api/v1/wh-transfer-out-library/saveTransferInfo 新增调拨出库跟条目
     * @apiHeaderExample {json} 请求头Header
     * {
     * "sso-token":"用户令牌"
     * }
     * @apiGroup Transfer
     * @apiParam {String} wayNumber 运单号
     * @apiParam {Integer} mIWarId 移入仓 id
     * @apiParam {Integer} rWarId 移出仓 id
     * @apiVersion 0.0.1
     * @apiDescription 用于新增调拨出库跟条目
     * @apiParamExample {json} 请求样例：
     * {
     * "wayNumber":"运单号",
     * "rWarId":22,
     * "mIWarId":2	,
     * "entry":[{"sku":"BOFGDMHB30","quantity":80,"position":"A仓"}..以及一些属性]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/saveTransferInfo")
    @RedisLock(key = Constants.TRANSFER_KE, maxWait = Constants.maxWait, timeout = Constants.timeout)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PermissionCheck(type = Constants.SAVE)
    public ResponseBase saveTransferInfo(@Valid @RequestBody WhTransferOutLibrary outLibrary, BindingResult result) {
        return outLibraryService.serviceSaveOutLibraryInfo(outLibrary, result);
    }

    /**
     * @api {POST} api/v1/wh-transfer-out-library/upTransferState 更新标记发货
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
    @PutMapping("/upTransferState")
    @PermissionCheck(type = Constants.MODIFY)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @HystrixCommand(fallbackMethod = "getPhpHystrix")
    public ResponseBase upTransferState(@RequestBody WhTransferOutLibrary outLibrary) {
        return outLibraryService.serviceUpOutLibraryStatus(outLibrary);
    }

    //注意，方法签名一定要要和api方法一致  熔断
    private ResponseBase getPhpHystrix(WhTransferOutLibrary outLibrary) {

        System.out.println("这里可以配置 redis 发送短信 异常报警");

        return JsonData.setResultError("操作人数太多，您被挤出来了，稍等重试");
    }


}
