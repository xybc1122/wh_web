package com.wh.controller.user;


import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.customize.IdempotentCheck;
import com.wh.customize.PermissionCheck;
import com.wh.service.type.IWhTypeService;
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
 * @since 2019-06-14
 */
@RestController
@RequestMapping("/api/v1/wh-type")
public class WhTypeController {
    @Autowired
    private IWhTypeService typeService;


    /**
     * 获得类型
     *
     * @return
     */
    @GetMapping("/getByWhTypeList")
    @PermissionCheck(type = Constants.VIEW)
    public ResponseBase getByWhTypeList() {
        return JsonData.setResultSuccess(typeService.list());
    }


}
