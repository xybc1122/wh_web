package com.wh.mapper.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.entity.position.WhPosition;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhPositionMapper extends BaseMapper<WhPosition> {
    @Results(id="optionMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "position_name",property = "positionName"),
            @Result(column = "asin",property = "asin")
    })
    @Select("select position_name from wh_position where id in (select position_id from wh_position_sku where asin=#{asin})")
    List<WhPosition> getBaseByProductId(String asin);

    @ResultMap("optionMap")
    @Select("select DISTINCT s.asin from((select id from  wh_position where position_name=#{optionName}) o inner join wh_position_sku s on o.id=s.position_id)")
    List<WhPosition> selectAsinByOptionName(String optionName);

}
