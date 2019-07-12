package com.wh.service.template.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.template.WhTemplate;
import com.wh.exception.LsException;
import com.wh.mapper.template.WhTemplateMapper;
import com.wh.service.template.IWhTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-12
 */
@Service
public class WhTemplateServiceImpl extends ServiceImpl<WhTemplateMapper, WhTemplate> implements IWhTemplateService {
    @Autowired
    private WhTemplateMapper templateMapper;

    @Override
    public List<Map<String, Object>> serviceSelTemplate(String type) {
        List<Map<String, Object>> mapList = templateMapper.selTemplate(type);
        if (mapList == null || mapList.size() <= 0) {
            throw new LsException("没有此模板");
        }
        return mapList;
    }
}
