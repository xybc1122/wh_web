package com.wh.controller.out.library.transfer;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
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
     * @api {POST} api/v1/wh-transfer-out-library 查询调拨出库跟条目
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
     * 删除调拨出库跟条目
     *
     * @return
     */
    @DeleteMapping("/delTransferInfo")
    @PermissionCheck(type = Constants.DELETE)
    public ResponseBase delTransferInfo(@RequestBody Map<String, Object> objectMap) {
        return outLibraryService.serviceDelOutLibraryInfo(objectMap);
    }

    /**
     * 新增调拨出库跟条目
     */
    @PostMapping("/saveTransferInfo")
    @PermissionCheck(type = Constants.SAVE)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    public ResponseBase saveTransferInfo(@Valid @RequestBody WhTransferOutLibrary outLibrary, BindingResult result) {
        return outLibraryService.serviceSaveOutLibraryInfo(outLibrary, result);
    }

    /**
     * 更新标记发货
     */
    @PutMapping("/upTransferInfo")
    @PermissionCheck(type = Constants.MODIFY)
    // @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @HystrixCommand(fallbackMethod = "getPhpHystrix")
    public ResponseBase upTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return outLibraryService.serviceUpOutLibraryStatus(outLibrary);
    }

    //注意，方法签名一定要要和api方法一致  熔断
    private ResponseBase getPhpHystrix(WhTransferOutLibrary outLibrary) {

        System.out.println("这里可以配置 redis 发送短信 异常报警");

        return JsonData.setResultError("操作人数太多，您被挤出来了，稍等重试");
    }


}
