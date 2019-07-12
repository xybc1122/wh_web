package com.wh.service.upload.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.entity.upload.WhUserUpload;
import com.wh.mapper.upload.WhUserUploadMapper;
import com.wh.service.upload.IWhUserUploadService;
import com.wh.toos.Constants;
import com.wh.toos.StaticVariable;
import com.wh.utils.CheckUtils;
import com.wh.utils.FileUtils;
import com.wh.utils.ReqUtils;
import com.wh.utils.UuIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-01
 */
@Service
public class WhUserUploadServiceImpl extends ServiceImpl<WhUserUploadMapper, WhUserUpload> implements IWhUserUploadService {


    @Override
    public ResponseBase serviceUserUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("files");
        if (files.size() == 0) {
            JsonData.setResultSuccess("files is null");
        }
        //记录用户上传信息~
        boolean isUpload = true;
        int fileCount = 0;
        String msg;
        StringBuilder sb = new StringBuilder();
        List<WhUserUpload> uploadList = new ArrayList<>();
        for (MultipartFile file : files) {
            // String contentType = filter.getContentType();//图片||文件类型
            String fileName = file.getOriginalFilename();//图片||文件名字
            String uuId = UuIDUtils.fileUuId(fileName);
            try {
                FileUtils.uploadFile(file.getBytes(), StaticVariable.SAVE_FILE_PATH, uuId);
                msg = "上传成功";
            } catch (Exception e) {
                isUpload = false;
                msg = "上传失败" + fileName;
                fileCount++;
                sb.append(fileName);
            }
            //记录用户上传信息 ~
            int uStatus = isUpload ? 0 : 1;
            WhUserUpload upload = new WhUserUpload(ReqUtils.getUid(), uuId, fileName, StaticVariable.SAVE_FILE_PATH, uStatus, ReqUtils.getUserName(), msg);
            if (isUpload) {
                uploadList.add(upload);
            }
            isUpload = true;
        }
        //这里存入数据库
        CheckUtils.saveResult(this.saveBatch(uploadList));
        String getMsg = "上传了" + files.size() + "个文件/" + "其中" + fileCount + "个文件失败~ 失败文件名字" + sb.toString() + "";
        return JsonData.setResultSuccess(getMsg, uploadList);

    }
}

