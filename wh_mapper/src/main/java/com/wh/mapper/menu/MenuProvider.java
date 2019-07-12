package com.wh.mapper.menu;


import com.wh.utils.ReqUtils;
import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 建动态sql语句
 */
public class MenuProvider {

    private final static String sqlKey = "m.`menu_id`,m.`m_name`,m.`parent_id`,m.`path`,m.`icon`," +
            "m.`menu_order`,m.`type`,m.`version`,m.`is_delete`,m.`is_parent_node`";

    public String findQueryMenuList() {
        SQL sql = new SQL();
        sql.SELECT(sqlKey + " FROM `wh_user_menu` AS m");
        sql.LEFT_OUTER_JOIN("(SELECT m_id,r_id FROM `wh_user_role_menu` WHERE is_delete=0) AS rm ON m.menu_id=rm.m_id");
        sql.LEFT_OUTER_JOIN("(SELECT r_id FROM `wh_user_role` WHERE is_delete=0) AS r ON r.r_id=rm.r_id");
        sql.WHERE(StrUtils.in(ReqUtils.getRoleId(), "rm.r_id"));
        sql.WHERE("m.is_delete =0");
        sql.ORDER_BY("m.`menu_order` asc");
        return sql.toString();
    }
}
