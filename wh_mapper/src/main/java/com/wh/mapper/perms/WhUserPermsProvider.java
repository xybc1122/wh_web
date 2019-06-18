package com.wh.mapper.perms;

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
        sql.LEFT_OUTER_JOIN("`wh_user_perms_operating` AS po ON po.`p_id` = p.`p_id`");
        sql.LEFT_OUTER_JOIN("`wh_user_role_perms` AS rp ON rp.`p_id` =p.`p_id`");
        sql.WHERE("po.api_url=" + "'" + apiUrl + "'");
        return sql.toString() + " AND " + StrUtils.in(rids, "rp.`r_id`") + "AND " + ALIAS + ".is_delete=0";
    }

    public String getPermissionAndOperating() {
        SQL sql = new SQL();
        sql.SELECT(" p.`p_id`,p.`p_name`,GROUP_CONCAT(po.`po_name`) AS poName, " +
                "GROUP_CONCAT(po.api_url) AS poApi FROM `wh_user_perms`AS " + ALIAS + "");
        sql.LEFT_OUTER_JOIN("`wh_user_perms_operating` AS po ON po.`p_id`= p.`p_id`");
        sql.GROUP_BY(ALIAS + ".`p_id`");
        sql.WHERE(ALIAS + ".is_delete=0");
        return sql.toString();
    }
}