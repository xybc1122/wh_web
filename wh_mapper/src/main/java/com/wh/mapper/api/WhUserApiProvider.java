package com.wh.mapper.api;


import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * @ClassName WhUserApiProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/11 11:01
 **/
public class WhUserApiProvider {

    public String selApiInfo(Map<String, Object> objectMap) {
        String rids = (String) objectMap.get("rids");
        SQL sql = new SQL();
        sql.SELECT("a.`a_id`,a.`a_name`,`api_url`FROM `wh_user_api` AS a");
        sql.LEFT_OUTER_JOIN("(SELECT a_id,r_id FROM `wh_user_role_api` WHERE is_delete=0) AS ra ON ra.`a_id` =a.`a_id`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "ra.`r_id`") +
                " AND a.is_delete=0  GROUP BY a.`a_id`";
    }

}
