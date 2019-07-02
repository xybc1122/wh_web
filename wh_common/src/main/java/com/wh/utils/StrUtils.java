package com.wh.utils;

import com.wh.exception.LsException;
import org.apache.poi.ss.usermodel.Cell;

import java.util.List;

/**
 * @ClassName StrUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/17 9:08
 **/
public class StrUtils {

    /**
     * 拼接删除in sql
     *
     * @param thisId
     * @return
     */
    public static String in(Object obj, String thisId) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            return sb.append(thisId).append(" IN (-1)").toString();
        }
        if (obj instanceof String) {
            String ids = (String) obj;
            String[] idsArr = ids.split(",");
            sb.append("\n").append(thisId).append(" in (");
            for (String id : idsArr) {
                sb.append(id).append(",");
            }
        } else if (obj instanceof List) {
            List idList = (List) obj;
            if (idList.size() <= 0) {
                return sb.append(thisId).append(" IN (-1)").toString();
            }


            sb.append("\n").append(thisId).append(" in (");
            for (Object id : idList) {
                sb.append(id).append(",");
            }
        }
        return sb.substring(0, sb.length() - 1) + ")";
    }

    public static Integer cInt(Cell cell) {
        String value = XlsUtils.getCellValue(cell);
        if (value == null) {
            return null;
        }
        return (int) Double.parseDouble(value);
    }

    public static Long cLon(Cell cell) {
        String value = XlsUtils.getCellValue(cell);
        if (value == null) {
            return null;
        }
        return Long.parseLong(value);
    }

    /**
     * 封装 String  类型转换
     *
     * @return
     */

    public static String cStr(Cell cell) {
        String value = XlsUtils.getCellValue(cell);
        if (value == null) {
            return null;
        }
        return value;
    }

}
