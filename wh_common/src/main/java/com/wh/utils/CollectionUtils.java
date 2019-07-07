package com.wh.utils;

import com.baomidou.mybatisplus.annotation.TableId;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName CollectionUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/19 14:38
 **/
public class CollectionUtils {


    /**
     * set Obj 转换 str
     *
     * @param set
     */
    public static Set<String> cStr(Set<Object> set) {
        if (set == null || set.size() <= 0) {
            return null;
        }
        Set<String> strSet = new HashSet<>();
        for (Object obj : set) {
            if (obj instanceof String) {
                strSet.add((String) obj);
            }

        }
        return strSet;
    }


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
