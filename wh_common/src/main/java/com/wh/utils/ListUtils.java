package com.wh.utils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName ListUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/19 14:38
 **/
public class ListUtils {




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
     *差集 (list1 - list2) 不一样的值
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

}
