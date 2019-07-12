package com.wh.mapper.perms;

import com.wh.entity.perms.WhUserPerms;
import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WhUserPermsProvider {
    private final static String ALIAS = "p";




    public String getPermission(Map<String, String> strMap) {
        String rids = strMap.get("rids");
        String apiUrl = strMap.get("apiUrl");
        SQL sql = new SQL();
        sql.SELECT("po.`po_name` FROM `wh_user_perms` AS p");
        sql.LEFT_OUTER_JOIN("(SELECT po_name,`p_id`,api_url FROM `wh_user_perms_operating` WHERE is_delete=0) AS po ON po.`p_id` = p.`p_id`");
        sql.LEFT_OUTER_JOIN("(SELECT r_id,p_id FROM `wh_user_role_perms` WHERE is_delete=0) AS rp ON rp.`p_id` =p.`p_id`");
        sql.WHERE("po.api_url=" + "'" + apiUrl + "'");
        return sql.toString() + " AND " + StrUtils.in(rids, "rp.`r_id`") + "AND " + ALIAS + ".is_delete=0";
    }




    public String getPermissionAndOperating(Map<String, Object> strMap) {
        //这里放着如果有动态查询需要配置的
        WhUserPerms entity = (WhUserPerms) strMap.get("entity");

        SQL sql = new SQL();
        sql.SELECT("p.version,p.`p_id`,p.`p_name`,GROUP_CONCAT(po.`po_name`) AS poName, " +
                "GROUP_CONCAT(po.api_url) AS poApi FROM `wh_user_perms`AS " + ALIAS + "");
        sql.LEFT_OUTER_JOIN("(SELECT r_id,p_id FROM `wh_user_role_perms` WHERE is_delete=0 GROUP BY `p_id`) AS rp ON rp.`p_id` =p.`p_id`");
        sql.LEFT_OUTER_JOIN("(SELECT p_id,po_name,api_url FROM `wh_user_perms_operating` WHERE is_delete=0) AS po ON po.`p_id`= p.`p_id`");
        return sql.toString() + " WHERE " + ALIAS + ".is_delete=0  GROUP BY " + ALIAS + ".`p_id` ";
    }
}
