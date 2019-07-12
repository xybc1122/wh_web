package com.wh.mapper.role;

import com.wh.entity.role.WhUserRole;
import com.wh.utils.ReqUtils;
import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WhUserRoleProvider {


    public String selRoleAndPerm(Map<String, Object> strMap) {
        //这里放着如果有动态查询需要配置的
        WhUserRole entity = (WhUserRole) strMap.get("entity");

        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT(" r.`r_id`, r.`r_name`,GROUP_CONCAT(p.`p_name`) pName,GROUP_CONCAT(p.`p_id`) pids , r.`create_date` FROM `wh_user_role` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("(SELECT r_id,p_id FROM `wh_user_role_perms` WHERE is_delete=0) AS rp ON rp.`r_id`=r.`r_id` ");
        sql.LEFT_OUTER_JOIN("(SELECT p_id , p_name FROM `wh_user_perms` WHERE is_delete=0) AS p ON p.`p_id`=rp.`p_id` ");
        sql.WHERE(alias + ".is_delete=0");
        sql.GROUP_BY(alias + ".`r_id`");
        return sql.toString();

    }

    public String selSignList(Map<String, String> strMap) {
        String rids = strMap.get("rids");
        SQL sql = new SQL();
        sql.SELECT("`role_sign` FROM `wh_user_role`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "`r_id`");
    }

}
