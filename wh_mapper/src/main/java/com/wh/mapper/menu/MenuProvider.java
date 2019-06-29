package com.wh.mapper.menu;


import com.wh.entity.menu.WhUserMenu;
import com.wh.store.AppendSqlStore;
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
        return new SQL() {{
            SELECT(sql + " FROM `wh_user_menu` AS m");
            LEFT_OUTER_JOIN("wh_user_role_menu AS rm ON m.menu_id=rm.m_id");
            LEFT_OUTER_JOIN("wh_user_role AS r ON r.r_id=rm.r_id");
            WHERE(StrUtils.in(rids, "rm.r_id"));
            ORDER_BY("m.`menu_order` asc");

            WHERE("m.is_delete =0");
        }}.toString();
    }


    public String findMenuPerms(WhUserMenu whUserMenu) {
        SQL sql = new SQL();
        String alias = "m";
        sql.SELECT("m.`menu_id`,GROUP_CONCAT(mp.api_url) AS apiUrl,`m_name`,GROUP_CONCAT(p.`perms`) " +
                "AS perms,m.create_date FROM `wh_user_menu` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`wh_user_menu_perms` AS mp ON mp.`m_id`=m.`menu_id`");
        sql.LEFT_OUTER_JOIN("`wh_user_perms` AS p ON p.`p_id` = mp.`p_id`");

        sql.WHERE("m.is_parent_node =0 AND m.is_delete =0");
        sql.GROUP_BY("m.`menu_id`");

        /**
         * 菜单名称查询
         */
        AppendSqlStore.sqlWhere(whUserMenu.getTreeName(), "`m_name` ", sql, alias);

        //创建时间 范围查询
        if (whUserMenu.getCreateDates() != null && (whUserMenu.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".create_date BETWEEN  " + whUserMenu.getCreateDates().get(0) + " AND " + whUserMenu.getCreateDates().get(1) + "");
        }

        return sql.toString();
    }


}
