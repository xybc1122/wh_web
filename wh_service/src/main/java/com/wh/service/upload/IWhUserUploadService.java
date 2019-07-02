package com.wh.service.upload;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.upload.WhUserUpload;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-01
 */
public interface IWhUserUploadService extends IService<WhUserUpload> {
    /**
     * 用户上传服务
     *
     * @return
     */
    ResponseBase serviceUserUpload(HttpServletRequest request);
}
