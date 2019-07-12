package com.wh.service.ot;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserOperatingTypeDto;
import com.wh.entity.ot.WhUserOperatingType;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
public interface IWhUserOperatingTypeService extends IService<WhUserOperatingType> {

    /**
     * 获得可配置的操作类型
     *
     * @return
     */
    Set<UserOperatingTypeDto> selOperatingType();



}
