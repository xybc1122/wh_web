package com.wh.service.template;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.entity.template.WhTemplate;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-12
 */
public interface IWhTemplateService extends IService<WhTemplate> {


    List<Map<String, Object>> serviceSelTemplate(String type);


}
