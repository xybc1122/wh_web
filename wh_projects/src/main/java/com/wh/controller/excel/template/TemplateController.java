package com.wh.controller.excel.template;

import com.wh.customize.PermissionCheck;
import com.wh.service.execl.ExeclService;
import com.wh.service.template.IWhTemplateService;
import com.wh.toos.Constants;
import com.wh.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TemplateController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/10 10:48
 **/
@RestController
@RequestMapping("/api/v1/template")
public class TemplateController {
    @Autowired
    private ExeclService execlService;

    @Autowired
    private IWhTemplateService templateService;

    /**
     * 下载导入模板
     *
     * @return
     */
    @GetMapping("/downloadTemplate")
    @PermissionCheck(type = Constants.VIEW)
    public void createOLTemplate(HttpServletRequest request, HttpServletResponse response, @RequestParam("type") String type) {
        String filePath = FileUtils.tempFilePath();
        execlService.exportTemplate(templateService.serviceSelTemplate(type), "模板", filePath, 15, 20);
        //下载文件
        FileUtils.downloadFile(filePath, response, request);

    }

}
