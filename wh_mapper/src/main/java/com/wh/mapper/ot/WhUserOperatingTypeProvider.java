package com.wh.mapper.ot;

import com.wh.utils.ReqUtils;
import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName WhUserOperatingTypeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/11 9:50
 **/
public class WhUserOperatingTypeProvider {

    public String selWhUserOperatingType(Map<String, Object> objectMap) {
        String rids = (String) objectMap.get("rids");
        SQL sql = new SQL();
        sql.SELECT("o.`o_id`,o.`t_name`FROM `wh_user_operating` AS o");
        sql.LEFT_OUTER_JOIN("(SELECT o_id,r_id FROM `wh_user_role_operating` WHERE  is_delete=0)AS  op ON op.`o_id` =o.`o_id`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "op.`r_id`") +
                " AND o.is_delete=0  GROUP BY  o.`o_id`";
    }


    public String selOperatingType(Map<String, String> strMap) {
        String apiUrl = strMap.get("apiUrl");
        SQL sql = new SQL();
        sql.SELECT("o.`t_name`FROM `wh_user_operating` AS o");
        sql.LEFT_OUTER_JOIN("(SELECT o_id,p_id FROM `wh_user_operating_perms` WHERE is_delete=0)AS op ON op.`o_id` =o.`o_id`");
        sql.LEFT_OUTER_JOIN("(SELECT o_id,a_id FROM `wh_user_operating_api` WHERE is_delete=0) AS oa ON oa.o_id =o.`o_id`");
        sql.LEFT_OUTER_JOIN("(SELECT a_id,api_url FROM  `wh_user_api` WHERE is_delete=0) AS a ON a.a_id =oa.`a_id`");

        sql.WHERE("op.`p_id` IN (SELECT `p_id` FROM `wh_user_role_perms` AS rp  WHERE " +
                "" + StrUtils.in(ReqUtils.getRoleId(), "r_id") + " AND is_delete=0  GROUP BY p_id) AND " +
                "o.is_delete =0 AND a.api_url=" + "'" + apiUrl + "'");
        sql.GROUP_BY("o.`o_id`");
        return sql.toString();
    }

}
