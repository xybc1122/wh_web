package com.wh.service.file;

import com.wh.base.ResponseBase;
import com.wh.entity.upload.WhUserUpload;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName FileDealWithService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 15:03
 **/
public interface FileDealWithService {

    /**
     * 上传文件处理
     *
     * @param upload
     * @return
     */
    List<ResponseBase> serviceFileDealWith(WhUserUpload upload);


}
