package com.wh.controller.out_library.transfer;


import com.wh.base.ResponseBase;
import com.wh.entity.out_library.transfer.WhTransferOutLibrary;
import com.wh.service.out_library.transfer.IWhTransferOutLibraryService;
import com.wh.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;

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
    public ResponseBase findByTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return PageInfoUtils.returnPage(outLibraryService.serviceSelOutLibraryInfo(outLibrary));
    }

    /**
     * 删除调拨出库跟条目
     *
     * @return
     */
    @DeleteMapping("/delTransferInfo")
    public ResponseBase delTransferInfo(@RequestBody Map<String, Object> objectMap) {
        return outLibraryService.serviceDelOutLibraryInfo(objectMap);
    }

    /**
     * 新增调拨出库跟条目
     */
    @PostMapping("/saveTransferInfo")
    public ResponseBase saveTransferInfo(@Valid @RequestBody WhTransferOutLibrary outLibrary, BindingResult result) {
        return outLibraryService.serviceSaveOutLibraryInfo(outLibrary, result);
    }

    /**
     * 更新标记发货
     */
    @PutMapping("/upTransferInfo")
    public ResponseBase upTransferInfo(@RequestBody WhTransferOutLibrary outLibrary) {
        return outLibraryService.serviceUpOutLibraryStatus(outLibrary);
    }
}
