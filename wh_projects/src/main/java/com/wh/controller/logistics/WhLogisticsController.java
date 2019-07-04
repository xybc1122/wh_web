package com.wh.controller.logistics;


import com.wh.base.ResponseBase;
import com.wh.customize.PermissionCheck;
import com.wh.service.logistics.IWhLogisticsService;
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
@RequestMapping("/api/v1/wh-logistics")
public class WhLogisticsController {
    @Autowired
    private IWhLogisticsService logisticsService;

    /**
     * 查询运输方式  值需要 id 跟 账号名
     *
     * @return
     */
    @GetMapping("/getLogisticsIdAndName")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase getLogisticsIdAndName() {

        return logisticsService.serviceGetLogisticsIdAndName();

    }


}
