package com.wh.mapper.position;

import java.util.Map;

public class WhPositionProvider {
    String getBaseByProductId(Map<String, Object> para){
        String sql="select position_name from wh_position where id=(select position_id from wh_position_sku where asin="+para.get("asin")+")";
        return sql;
    }
}
