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
        sql.SELECT("`id`,`t_number`,`r_war_id`,`m_i_war_id`,`type`,`status`," +
                "`way_number`,`create_date`,`version` FROM `wh_transfer_out_library` AS " + alias + "");
//        //查询移出仓库
//        AppendSqlStore.sqlWhere(outLibrary.getrWarehouse(), "`r_warehouse` ", sql, alias);
//        //查询移入仓库
//        AppendSqlStore.sqlWhere(outLibrary.getmIWarehouse(), "`m_i_warehouse` ", sql, alias);
        //查询调拨单号
        AppendSqlStore.sqlWhere(outLibrary.gettNumber(), "`t_number` ", sql, alias);
        //查询运单号
        AppendSqlStore.sqlWhere(outLibrary.getWayNumber(), "`way_number` ", sql, alias);

        sql.WHERE(alias + ".is_delete=0");
        return sql.toString();
    }


}
