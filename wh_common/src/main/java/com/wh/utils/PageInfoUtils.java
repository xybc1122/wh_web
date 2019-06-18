package com.wh.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageInfoUtils {
    /**
     * 封装分页
     *
     * @param pageInfo
     * @return
     */
    public static Map<String, Object> getPage(PageInfo pageInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", pageInfo.getPageNum());//当前页
        data.put("dataList", pageInfo.getList());//数据
        return data;
    }

    /**
     * /**
     * 设置分页
     *
     * @param pageSize
     * @param currentPage
     */
    public static void setPage(Integer pageSize, Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        //set page
        PageHelper.startPage(currentPage, pageSize);
    }

    /**
     * 返回分页
     *
     * @return
     */
    public static ResponseBase returnPage(List<?> obj) {
        PageInfo<?> pageInfo = new PageInfo<>(obj);
        return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo));
    }
}
