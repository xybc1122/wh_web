package com.wh.service.ot.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.UserOperatingTypeDto;
import com.wh.entity.ot.WhUserOperatingType;
import com.wh.mapper.ot.WhUserOperatingTypeMapper;
import com.wh.service.ot.IWhUserOperatingTypeService;
import com.wh.service.redis.RedisService;
import com.wh.utils.ReqUtils;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class WhUserOperatingTypeServiceImpl extends ServiceImpl<WhUserOperatingTypeMapper, WhUserOperatingType> implements IWhUserOperatingTypeService {
    @Autowired
    private WhUserOperatingTypeMapper operatingTypeMapper;
    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;


    @Override
    public Set<UserOperatingTypeDto> selOperatingType() {
        return mapperFacade.mapAsSet(operatingTypeMapper.selWhUserOperatingType(ReqUtils.getRoleId()), UserOperatingTypeDto.class);
    }


}
