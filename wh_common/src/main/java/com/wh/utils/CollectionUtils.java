package com.wh.utils;

import com.baomidou.mybatisplus.annotation.TableId;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName CollectionUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/19 14:38
 **/
public class CollectionUtils {

    /**
     * 交集 一样的值
     *
     * @param oneList
     * @param twoList
     * @return
     */
    public static List<Integer> intersection(List<Integer> oneList, List<Integer> twoList) {
        return oneList.stream().filter(twoList::contains).collect(toList());
    }

    /**
     * 差集 (list1 - list2) 不一样的值
     *
     * @param oneList
     * @param twoList
     * @return
     */
    public static List<Integer> reduce(List<Integer> oneList, List<Integer> twoList) {
        return oneList.stream().filter(item -> !twoList.contains(item)).collect(toList());
    }

    /**
     * 判断 List是否为空 或者 size小于0
     */
    public static boolean isList(List<?> objList) {
        return objList != null && objList.size() > 0;
    }


    /**
     * 两个List比较 顺序也必须一样
     *
     * @return
     */
    public static boolean eqOrderList(List<String> sqlList, List<String> fileList) {
        if (fileList == null) {
            return false;
        }
        if (sqlList.size() != fileList.size()) {
            return false;
        }
        for (int i = 0; i < sqlList.size(); i++) {
            System.out.println(fileList.get(i).trim());
            if (!(sqlList.get(i).trim()).equals(StrUtils.specialUnicode(fileList.get(i).trim()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 设置in 查询  id 集合
     *
     * @param list
     * @return
     */
    public static List<Long> setInList(List list) {
        List<Long> idList = new ArrayList<>();
        //这里设置 in 查询 id
        try {
            for (Object obj : list) {
                Field[] fields = obj.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Annotation[] annotations = field.getDeclaredAnnotations();
                    for (Annotation ann : annotations) {
                        if (ann instanceof TableId) {
                            idList.add((Long) field.get(obj));
                            break;
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return idList;
    }

}
