package com.wh.store;

import com.wh.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName AppendSqlStore 拼接sql 商店
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/27 8:57
 **/
public class AppendSqlStore {


    /**
     * 通用拼接set
     *
     * @param sb
     * @param p
     */
//    public static void set(StringBuilder sb, ParentUploadInfo p) {
//        sb.append(p.getCreateDate()).append(",");
//        StrUtils.appBuider(sb, p.getCreateUser());
//        sb.append(",");
//        sb.append(p.getRecordingId()).append("),");
//    }

    /**
     * 封装 where IN查询条件
     *
     * @param k   实体的字段
     * @param v   数据库的字段
     * @param sql
     */
    public static void sqlWhere(Object k, String v, SQL sql, String status, String alias) {
        String c = vJudge(v);
        if (k != null && k != "") {
            if (status.equals(Constants.SELECT)) {
                if (k instanceof String) {
                    sql.WHERE("POSITION('" + k + "' IN " + alias + "." + c + ")");
                } else {
                    sql.WHERE(alias + "." + c + "=" + k);
                }
            }
        }
    }

    /**
     * sql 参数判断  拼接
     *
     * @param v
     * @return
     */
    private static String vJudge(String v) {
        if (StringUtils.isNotBlank(v)) {
            //先进来看看有没有. 并且没有`的
            if (v.contains(".") && !v.contains("`")) {
                //截取
                int index = v.indexOf(".");
                //拿到左参数
                String leftV = v.substring(0, index);
                //拿到右参数
                String rightV = v.substring(index + 1);
                return leftV + "." + "`" + rightV + "`";
                //这里是没有. 并且没有`
            } else if (!v.contains(".") && !v.contains("`")) {
                return "`" + v + "`";
            } else {
                return v;
            }
        }
        //如果是null
        return null;
    }

    /**
     * 设置sql 对应的表头
     *
     * @param sqlMode
     * @param v1
     * @param v2
     * @return
     */
    public static String setSqlTable(Integer sqlMode, String v1, String v2) {
        String sqlTable = v1;
        if (sqlMode != null && sqlMode == 1) {
            sqlTable = v2;
        }
        return sqlTable;
    }
}
