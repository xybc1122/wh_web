package com.wh.mapper.template;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.template.WhTemplate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-12
 */
public interface WhTemplateMapper extends BaseMapper<WhTemplate> {


    @Select("SELECT `id`,`pid`,`content`,`file_name` FROM `wh_template` WHERE `type`= #{type} ORDER BY sort")
    List<Map<String, Object>> selTemplate(@Param("type") String type);


}
