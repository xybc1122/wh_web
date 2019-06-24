package com.wh.entity.dto;

import java.util.List;

/**
 * @ClassName DelIdsDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/19 10:43
 **/
public class DelIdsDto {
    /**
     * 这里这个 thisId 对应 一对多删除 的主 id
     */
    private Integer thisId;

    /**
     * 需要删除的 ids
     */
    private List<Integer> idDelList;

    public Integer getThisId() {
        return thisId;
    }

    public void setThisId(Integer thisId) {
        this.thisId = thisId;
    }

    public List<Integer> getIdDelList() {
        return idDelList;
    }

    public void setIdDelList(List<Integer> idDelList) {
        this.idDelList = idDelList;
    }
}
