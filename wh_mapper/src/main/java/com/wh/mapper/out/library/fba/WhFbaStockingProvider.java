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
        sql.SELECT("l.transport,s.`site`,a.`account`,"+alias+".create_date," + alias + ".account_id," + alias + ".site_id,"
                + alias + ".version," + alias + ".`id`, `single_number`, `fs_state`," +
                "`d_information`," + alias + ".`transport_id`,`n_of_boxes`," + alias + ".total_amount," +
                "" + alias + ".total_price," + alias + ".record_no\n" +
                "FROM `wh_fba_stocking` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("wh_site AS s on s.id= " + alias + ".site_id");
        sql.LEFT_OUTER_JOIN("(SELECT `id`,`account` FROM `wh_seller_account` WHERE is_delete=0) AS a on a.id=" + alias + ".account_id");
        sql.LEFT_OUTER_JOIN("(SELECT `id`,`transport` FROM `wh_logistics` WHERE is_delete=0) AS l on l.id=" + alias + ".transport_id");
        //查询站点
        AppendSqlStore.sqlWhere(whFbaStocking.getSite(), "`site` ", sql, "s");

        //查询账号
        AppendSqlStore.sqlWhere(whFbaStocking.getAccount(), "`account` ", sql, "a");
        //查询单号
        AppendSqlStore.sqlWhere(whFbaStocking.getSingleNumber(), "`single_number` ", sql, alias);

        //查询单据号
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
