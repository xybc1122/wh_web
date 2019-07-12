package com.wh.utils.excel;

/**
 * Created by wtj on 2018/5/2.
 */

import java.util.ArrayList;
import java.util.List;

public class Column {
    //单元格内容
    private String content;
    //字段名称，用户导出表格时反射调用
    private String fieldName;
    //这个单元格的集合
    private List<Column> listTpamscolumn = new ArrayList<Column>();

    int totalRow;
    int totalCol;
    int row;//excel第几行
    int col;//excel第几列
    int rLen; //excel 跨多少行
    int cLen;//excel跨多少列
    private boolean HasChilren;//是否有子节点
    private int tree_step;//树的级别 从0开始
    private String id;
    private String pid;

    public Column() {
    }

    public Column(String content, String fieldName) {
        this.content = content;
        this.fieldName = fieldName;
    }

    public Column(String fieldName, String content, int tree_step) {
        this.tree_step = tree_step;
        this.fieldName = fieldName;
        this.content = content;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalCol() {
        return totalCol;
    }

    public void setTotalCol(int totalCol) {
        this.totalCol = totalCol;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasChilren() {
        return HasChilren;
    }

    public void setHasChilren(boolean hasChilren) {
        HasChilren = hasChilren;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<Column> getListTpamscolumn() {
        return listTpamscolumn;
    }

    public void setListTpamscolumn(List<Column> listTpamscolumn) {
        this.listTpamscolumn = listTpamscolumn;
    }

    public int getTree_step() {
        return tree_step;
    }

    public void setTree_step(int tree_step) {
        this.tree_step = tree_step;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getrLen() {
        return rLen;
    }

    public void setrLen(int rLen) {
        this.rLen = rLen;
    }

    public int getcLen() {
        return cLen;
    }

    public void setcLen(int cLen) {
        this.cLen = cLen;
    }
}
