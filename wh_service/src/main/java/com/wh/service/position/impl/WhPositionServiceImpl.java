package com.wh.service.position.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.position.WhPosition;
import com.wh.mapper.position.WhPositionMapper;
import com.wh.service.position.WhPositionService;
import org.springframework.beans.factory.annotation.Autowired;

public class WhPositionServiceImpl extends ServiceImpl<WhPositionMapper, WhPosition> implements WhPositionService {

    @Autowired
    private WhPositionMapper whPositionMapper;

    @Override
    public WhPosition getBaseByProductId(String asin) {
         //return whPositionMapper.getBaseByProductId(asin);
        return null;
    }

    @Override
    public String selectAsinByOptionName(String optionName) {
        //return whPositionMapper.selectAsinByOptionName(optionName);
        return null;
    }
}
