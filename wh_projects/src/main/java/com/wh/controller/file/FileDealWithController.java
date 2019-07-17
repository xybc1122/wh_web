package com.wh.controller.file;

import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.upload.WhUserUpload;
import com.wh.service.file.FileDealWithService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName FileDealWithController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 15:04
 * 11
 **/
@RestController
@RequestMapping("/api/v1/file")
public class FileDealWithController {
    @Autowired
    private FileDealWithService fileDealWithService;


    /**
     * @api {POST} api/v1/file/fileDealWith xlsx 表处理数据处理接口
     * @apiHeaderExample {json} 请求头Header
     * {
     * "sso_token":"用户令牌"
     * "ide_token":"接口幂等令牌"
     * }
     * @apiGroup File
     * @apiVersion 0.0.1
     * @apiDescription 用于xlsx 表处理数据处理接口
     * @apiParamExample {json} 请求样例：
     * 需要上传成功后的文件对象
     * {"uploadSuccessList": [
     * {
     * "remark": "上传成功",
     * "createDate": 1561974431274,
     * "createUser": "eeee",
     * "modifyDate": null,
     * "modifyUser": null,
     * "delOrNot": null,
     * "currentPage": null,
     * "pageSize": null,
     * "createDates": null,
     * "version": null,
     * "id": 4,
     * "uid": 406,
     * "uuidName": "01e57f3d94ee49cf86d6b37826b96d6b.xlsx",
     * "name": "新建 Microsoft Excel 工作表.xlsx",
     * "filePath": "E:/file/",
     * "uStatus": 0,
     * "deStatus": null,
     * "url": null,
     * "uploadSuccessList": null
     * }
     * ]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PermissionCheck(type = Constants.SAVE)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    @PostMapping("/fileDealWith")
    public List<ResponseBase> fileDealWith(@RequestBody WhUserUpload upload) {
        return fileDealWithService.serviceFileDealWith(upload);
    }
}
