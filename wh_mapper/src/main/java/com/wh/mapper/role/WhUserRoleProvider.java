package com.wh.mapper.role;

import com.wh.entity.role.WhUserRole;
import com.wh.utils.ReqUtils;
import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WhUserRoleProvider {


    public String selRoleAndPerm(Map<String, Object> strMap) {
        String rids = (String) strMap.get("rids");
        //这里放着如果有动态查询需要配置的
        WhUserRole entity = (WhUserRole) strMap.get("entity");

        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT(" r.`r_id`, r.`r_name`,GROUP_CONCAT(p.`p_name`) pName,GROUP_CONCAT(p.`p_id`) pids , r.`create_date` FROM `wh_user_role` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("(SELECT r_id,p_id FROM `wh_user_role_perms` WHERE is_delete=0) AS rp ON rp.`r_id`=r.`r_id` ");
        sql.LEFT_OUTER_JOIN("(SELECT p_id , p_name FROM `wh_user_perms` WHERE is_delete=0) AS p ON p.`p_id`=rp.`p_id` ");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "r.`r_id`") +
                "AND " + alias + ".is_delete=0  GROUP BY " + alias + ".`r_id`";

    }

    public String selSignList(Map<String, String> strMap) {
        String rids = strMap.get("rids");
        SQL sql = new SQL();
        sql.SELECT("`r_name` FROM `wh_user_role`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "`r_id`");
    }

    public String selRole(Map<String, Object> strMap) {
        Long uid = (Long) strMap.get("uid");
        Integer tid = (Integer) strMap.get("tid");
        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT("r.`r_id`,r.`r_name`FROM `wh_user_role` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("(SELECT r_id,u_id,t_id FROM `wh_user_role_user` WHERE is_delete=0)  AS ur ON ur.r_id =r.r_id");
        sql.WHERE("ur.u_id =" + uid);
        sql.WHERE("ur.t_id =" + tid);
        return sql.toString();
    }
}
