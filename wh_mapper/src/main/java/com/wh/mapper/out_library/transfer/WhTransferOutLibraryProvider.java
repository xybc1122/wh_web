package com.wh.mapper.out_library.transfer;

import com.wh.entity.out_library.transfer.WhTransferOutLibrary;
import com.wh.store.AppendSqlStore;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName WhTransferOutLibraryProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 12:55
 **/
public class WhTransferOutLibraryProvider {


    public String selOutLibraryInfo(WhTransferOutLibrary outLibrary) {
        SQL sql = new SQL();
        String alias = "tol";
        sql.SELECT("r.wh_name AS rWarName,m.wh_name AS mIWarName," + alias + ".`id`,`t_number`,`r_war_id`,`m_i_war_id`," + alias + ".`type`," + alias + ".`status`," +
                "`way_number`," + alias + ".`create_date`," + alias + ".`version` FROM `wh_transfer_out_library` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("wh_base AS r on r.id = " + alias + ".r_war_id");
        sql.LEFT_OUTER_JOIN("wh_base AS m on m.id = " + alias + ".m_i_war_id");
        //查询移出仓库
        AppendSqlStore.sqlWhere(outLibrary.getrWarName(), "wh_name", sql, "r");
        //查询移入仓库
        AppendSqlStore.sqlWhere(outLibrary.getmIWarName(), "wh_name", sql, "r");
        //查询调拨单号
        AppendSqlStore.sqlWhere(outLibrary.gettNumber(), "`t_number` ", sql, alias);
        //查询运单号
        AppendSqlStore.sqlWhere(outLibrary.getWayNumber(), "`way_number` ", sql, alias);

        sql.WHERE(alias + ".is_delete=0");
        return sql.toString();
    }


}
