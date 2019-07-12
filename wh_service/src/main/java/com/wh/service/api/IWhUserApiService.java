package com.wh.service.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.api.WhUserApi;
import com.wh.entity.dto.UserApiDto;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
public interface IWhUserApiService extends IService<WhUserApi> {


    /**
     * 通过操作列表id 去查询可以显示的操作api路径
     *
     * @return
     */
    List<UserApiDto> serviceSelApiInfo();

}
