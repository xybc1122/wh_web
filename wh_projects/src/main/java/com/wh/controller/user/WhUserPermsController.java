package com.wh.controller.user;

import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.service.perms.IWhUserPermsService;
import com.wh.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WhUserPermsController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/5 11:00
 **/
@RestController
@RequestMapping("/api/v1/perms")
public class WhUserPermsController {

    @Autowired
    private IWhUserPermsService userPermsService;

    /**
     * 通过角色查询菜单信息
     *
     * @return
     */
    @GetMapping("/selByPerms")
    public ResponseBase selByPerms(@RequestParam("apiUrl") String apiUrl) {
        return JsonData.setResultSuccess(userPermsService.serviceGetPermission(ReqUtils.getRoleId(), apiUrl));

    }
}
