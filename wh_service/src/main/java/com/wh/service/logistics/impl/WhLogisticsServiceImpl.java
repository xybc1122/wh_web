package com.wh.service.logistics.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.dto.LogisticsDto;
import com.wh.entity.logistics.WhLogistics;
import com.wh.mapper.logistics.WhLogisticsMapper;
import com.wh.service.logistics.IWhLogisticsService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-02
 */
@Service
public class WhLogisticsServiceImpl extends ServiceImpl<WhLogisticsMapper, WhLogistics> implements IWhLogisticsService {
    /**
     * dto 转换工具
     */
    @Autowired
    private MapperFacade mapperFacade;


    @Override
    public ResponseBase serviceGetLogisticsIdAndName() {
        List<WhLogistics> logisticsList = this.lambdaQuery().select(WhLogistics::getId, WhLogistics::getTransport).list();
        return JsonData.setResultSuccess( mapperFacade.mapAsList(logisticsList, LogisticsDto.class));
    }
}
