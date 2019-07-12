package com.wh.service.fallback;

import com.wh.base.ResponseBase;
import com.wh.service.feign.PhpFeignClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName PhpClientFallback
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 13:04
 * 针对php调用服务，错降级处理
 **/
@Component
public class PhpClientFallback implements PhpFeignClient {
    @Override
    public ResponseBase checkAsinQ(String sku) {

        System.out.println("checkAsinQ error 打印日志");
        return null;
    }

    @Override
    public ResponseBase setPhpTransferOutLibrary(Map<String, Object> params) {
        System.out.println("setPhpTransferOutLibrary error 打印日志");


        return null;
    }
}
