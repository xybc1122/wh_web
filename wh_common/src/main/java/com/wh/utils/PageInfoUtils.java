package com.wh.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.user.UserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageInfoUtils {
    /**
     * 返回分页
     *
     * @return
     */
    public static ResponseBase pageResult(List<?> oldList, List<?> newList) {
        Map<String, Object> objectMap = PageInfoUtils.setMap(oldList, newList);
        return PageInfoUtils.returnPage(objectMap, newList);
    }

    /**
     * 封装分页
     *
     * @param pageInfo
     * @return
     */
    private static Map<String, Object> getPage(PageInfo pageInfo, List<?> newList) {
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", pageInfo.getPageNum());//当前页
        if (newList == null) {
            data.put("dataList", pageInfo.getList());//数据
        }
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


    private static Map<String, Object> setMap(List<?> obj, List<?> newList) {
        PageInfo<?> pageInfo = new PageInfo<>(obj);
        return PageInfoUtils.getPage(pageInfo, newList);
    }

    private static ResponseBase returnPage(Map<String, Object> objectMap, List<?> obj) {
        if (obj != null) {
            objectMap.put("dataList", obj);
        }
        return JsonData.setResultSuccess(objectMap);
    }

}
