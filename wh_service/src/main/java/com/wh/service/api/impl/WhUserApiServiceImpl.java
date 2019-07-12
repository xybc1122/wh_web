package com.wh.service.api.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.api.WhUserApi;
import com.wh.entity.dto.UserApiDto;
import com.wh.entity.dto.UserOperatingTypeDto;
import com.wh.entity.ot.WhUserOperatingType;
import com.wh.mapper.api.WhUserApiMapper;
import com.wh.service.api.IWhUserApiService;
import com.wh.service.ot.IWhUserOperatingTypeService;
import com.wh.utils.ReqUtils;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-11
 */
@Service
public class WhUserApiServiceImpl extends ServiceImpl<WhUserApiMapper, WhUserApi> implements IWhUserApiService {
    @Autowired
    private WhUserApiMapper whUserApiMapper;

    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public List<UserApiDto> serviceSelApiInfo() {
        return mapperFacade.mapAsList(whUserApiMapper.selApiInfo(ReqUtils.getRoleId()), UserApiDto.class);

    }
}
