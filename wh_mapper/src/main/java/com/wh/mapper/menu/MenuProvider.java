package com.wh.mapper.menu;


import com.wh.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 建动态sql语句
 */
public class MenuProvider {

    private final static String sql = "m.`menu_id`,m.`m_name`,m.`parent_id`,m.`path`,m.`icon`," +
            "m.`menu_order`,m.`type`,m.`version`,m.`is_delete`,m.`is_parent_node`";

    public String findQueryMenuList(final Map<String, Object> objectMap) {
        String rids = (String) objectMap.get("rids");
        Integer tid = (Integer) objectMap.get("tid");
        return new SQL() {{
            SELECT(sql + " FROM `wh_user_menu` AS m");
            LEFT_OUTER_JOIN("(SELECT m_id,r_id,t_id FROM `wh_user_role_menu` WHERE is_delete=0) AS rm ON m.menu_id=rm.m_id");
            LEFT_OUTER_JOIN("(SELECT r_id FROM `wh_user_role` WHERE is_delete=0) AS r ON r.r_id=rm.r_id");
//            LEFT_OUTER_JOIN("(SELECT tenant_id FROM `wh_warehouse_tenant` WHERE is_delete=0) AS t ON t.`tenant_id`=rm.`t_id`");
            WHERE(StrUtils.in(rids, "rm.r_id"));
            WHERE("rm.`t_id`=" + tid);
            WHERE("m.is_delete =0");
            ORDER_BY("m.`menu_order` asc");
        }}.toString();
    }
}
