package com.wh.controller.ot;


import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.ot.IWhUserOperatingTypeService;
import com.wh.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
@RestController
@RequestMapping("/api/v1/wh-user-operating-type")
public class WhUserOperatingTypeController {

    @Autowired
    private IWhUserOperatingTypeService operatingService;


}
