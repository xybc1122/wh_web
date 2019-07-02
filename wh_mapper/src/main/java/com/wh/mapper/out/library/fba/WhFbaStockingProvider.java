package com.wh.mapper.out.library.fba;


import com.wh.entity.out.library.fba.WhFbaStocking;
import com.wh.store.AppendSqlStore;
import org.apache.ibatis.jdbc.SQL;

/**
 * 建动态sql语句
 */
public class WhFbaStockingProvider {


    public String findQueryFbaList(WhFbaStocking whFbaStocking) {
        SQL sql = new SQL();
        String alias = "fs";
        sql.SELECT("" + alias + ".version,`id`,`record_no`,`fs_state`,`site`,\n" +
                " `d_information`,`ship_methods`,`n_of_boxes`,`account`\n" +
                "FROM `wh_fba_stocking` AS " + alias + "");
        //查询站点
        AppendSqlStore.sqlWhere(whFbaStocking.getSite(), "`site` ", sql, alias);
        //查询账号
        AppendSqlStore.sqlWhere(whFbaStocking.getAccount(), "`account` ", sql, alias);
        //查询单号
        AppendSqlStore.sqlWhere(whFbaStocking.getRecordNo(), "`record_no` ", sql, alias);
        //查询状态
        AppendSqlStore.sqlWhere(whFbaStocking.getFsState(), "`fs_state` ", sql, alias);

        //创建时间 范围查询
        if (whFbaStocking.getCreateDates() != null && (whFbaStocking.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".create_date BETWEEN  " + whFbaStocking.getCreateDates().get(0) + " AND " + whFbaStocking.getCreateDates().get(1) + "");
        }
        sql.WHERE(alias + ".is_delete=0");
        return sql.toString();
    }


}
