package com.wh.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @ClassName PageUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/10 15:38
 **/
public class PageUtils {

    /**
     * /**
     * 设置分页
     *
     * @param pageSize
     * @param currentPage
     */
    public static <T> Page<T> setPage(Integer currentPage, Integer pageSize) {
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        //set page
        return new Page<>(currentPage, pageSize);
    }
}
