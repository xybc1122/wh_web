package com.wh.controller.upload;

import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.entity.upload.WhUserUpload;
import com.wh.service.upload.IWhUserUploadService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 14:06
 **/
@RestController
@RequestMapping("/api/v1/upload")
public class UploadController {

    @Autowired
    private IWhUserUploadService userUploadService;

    /**
     * 上传接口
     *
     * @param request
     * @return
     */
    @PostMapping("/file")
    @PermissionCheck(type = Constants.SAVE)
    @IdempotentCheck(type = Constants.IDEMPOTENT_CHECK_HEADER)
    public ResponseBase uploadFile(HttpServletRequest request) {
        return userUploadService.serviceUserUpload(request);
    }



}
