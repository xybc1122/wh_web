package com.wh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author yyk
 * @date 2019/7/15 14:09
 * @description
 */
public class DateUtil {
    /**
     * 时间转换成特定的格式
     * @Param [date]
     * @Return java.lang.String
     * @Date 2019/7/15 17:16
     * @Author yyk
     */

    public static String setDateFormat(Date date){
        if(date==null){
            return "";
        }else{
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d=format.format(date);
            return d;
        }
    }
}
