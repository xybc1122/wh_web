package com.wh.controller.site;


import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.site.IWhSiteService;
import com.wh.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
@RestController
@RequestMapping("/api/v1/wh-site")
public class WhSiteController {
    @Autowired
    private IWhSiteService whSiteService;


    /**
     * 创建幂等token
     *
     * @return
     */
    @GetMapping("/getSite")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase getSite() {
        return whSiteService.serviceGetSite();

    }


}
