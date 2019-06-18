package com.wh.mapper.role;

import com.wh.entity.role.WhUserRole;
import org.apache.ibatis.jdbc.SQL;

public class WhUserRoleProvider {


    public String selRoleAndPerm(WhUserRole role) {
        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT(" r.`r_id`, r.`r_name`,GROUP_CONCAT(p.`p_name`) pName ,r.`create_date`" +
                " FROM `wh_user_role` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`wh_user_role_perms` AS rp ON rp.`r_id`=r.`r_id`");
        sql.LEFT_OUTER_JOIN("`wh_user_perms` AS  p ON p.`p_id`=rp.`p_id`");
        sql.GROUP_BY(alias + ".`r_id`");
        sql.WHERE(alias + ".is_delete=0");
        //这里留着条件查询
        return sql.toString();
    }
}