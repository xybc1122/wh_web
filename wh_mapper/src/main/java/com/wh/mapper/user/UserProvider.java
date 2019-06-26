package com.wh.mapper.user;


import com.wh.entity.dto.UserDto;
import com.wh.store.AppendSqlStore;
import com.wh.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {


    public String findUsers(UserDto uInfo) {
        SQL sql = new SQL();
        String alias = "u";
        sql.SELECT("u.version,u.type,u.uid,u.name,u.user_name,u.account_status," +
                "GROUP_CONCAT(r.`r_name`)AS rName,GROUP_CONCAT(r.`r_id`)AS rids," +
                "u.create_date");
        sql.FROM("wh_user_info AS " + alias + "");
        sql.LEFT_OUTER_JOIN("wh_user_role_user AS ur ON(ur.u_id=u.uid)");
        sql.LEFT_OUTER_JOIN("wh_user_role AS r ON(r.r_id=ur.r_id)");
        //用户类型
        AppendSqlStore.sqlWhere(uInfo.getType(), "`type` ", sql, alias);
        //用户账号
        AppendSqlStore.sqlWhere(uInfo.getUserName(), "`user_name` ", sql, alias);
        //用户名
        AppendSqlStore.sqlWhere(uInfo.getName(), "`name`", sql,  alias);
        //角色名字
        AppendSqlStore.sqlWhere(uInfo.getrName(), "r_name", sql, "r");
        //用户状态
        AppendSqlStore.sqlWhere(uInfo.getAccountStatus(), "account_status", sql, alias);
        //创建时间
        if (uInfo.getCreateDates() != null && (uInfo.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".create_date BETWEEN  " + uInfo.getCreateDates().get(0) + " AND " + uInfo.getCreateDates().get(1) + "");
        }
        sql.WHERE(alias + ".is_delete=0");
        sql.GROUP_BY(alias + ".uid");
        return sql.toString();
    }

}
