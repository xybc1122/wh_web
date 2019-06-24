package com.wh.controller.user;


import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.type.IWhTypeService;
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
    public ResponseBase getByWhTypeList() {
        return JsonData.setResultSuccess(typeService.list());
    }


}
