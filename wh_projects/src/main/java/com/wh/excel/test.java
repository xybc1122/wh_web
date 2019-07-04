package com.wh.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName test
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 15:01
 **/
public class test {


    public static void main(String[] args) throws Exception {


//        单级的表头
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("登录名", "u_login_id");
//        Map<String, String> map1 = new HashMap<String, String>();
//        map1.put("用户名", "u_name");
//        Map<String, String> map2 = new HashMap<String, String>();
//        map2.put("角色", "u_role");
//        Map<String, String> map3 = new HashMap<String, String>();
//        map3.put("部门", "u_dep");//d_name
//        Map<String, String> map4 = new HashMap<String, String>();
//        map4.put("用户类型", "u_type");
//        List<Map<String, String>> titleList = new ArrayList<>();
//        titleList.add(map);
//        titleList.add(map1);
//        titleList.add(map2);
//        titleList.add(map3);
//        titleList.add(map4);
//        //单级的 行内数据
//        List<Map<String, String>> rowList = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            Map m = new HashMap<String, String>();
//            m.put("u_login_id", "登录名" + i);
//            m.put("u_name", "张三" + i);
//            m.put("u_role", "角色" + i);
//            m.put("u_dep", "部门" + i);
//            m.put("u_type", "用户类型" + i);
//            rowList.add(m);
//        }
//            ExcelTool excelTool = new ExcelTool("单级表头的表格", 15, 20);
//        List<Column> titleData = excelTool.columnTransformer(titleList);
//        excelTool.exportExcel(titleData, rowList, "D://outExcel.xls", true, false);

//        List<Map> 数据 多级表头, 数据如下:
//        登录名 姓名 aa
//        角色 部门
        List<Map<String, String>> titleList = new ArrayList<>();
        Map<String, String> titleMap = new HashMap<String, String>();
        titleMap.put("id", "11");
        titleMap.put("pid", "0");
        titleMap.put("content", "登录名");
        titleMap.put("fielName", "u_login_id");
        Map<String, String> titleMap1 = new HashMap<String, String>();
        titleMap1.put("id", "1");
        titleMap1.put("pid", "0");
        titleMap1.put("content", "姓名");
        titleMap1.put("fielName", "u_name");
        Map<String, String> titleMap2 = new HashMap<String, String>();
        titleMap2.put("id", "2");
        titleMap2.put("pid", "0");
        titleMap2.put("content", "角色加部门");
        titleMap2.put("fielName", null);
        Map<String, String> titleMap3 = new HashMap<String, String>();
        titleMap3.put("id", "3");
        titleMap3.put("pid", "2");
        titleMap3.put("content", "角色");
        titleMap3.put("fielName", "u_role");
        Map<String, String> titleMap4 = new HashMap<String, String>();
        titleMap4.put("id", "4");
        titleMap4.put("pid", "2");
        titleMap4.put("content", "部门");
        titleMap4.put("fielName", "u_dep");
        Map<String, String> titleMap5 = new HashMap<String, String>();
        titleMap5.put("id", "22");
        titleMap5.put("pid", "0");
        titleMap5.put("content", "角色加部门1");
        titleMap5.put("fielName", null);
        Map<String, String> titleMap6 = new HashMap<String, String>();
        titleMap6.put("id", "22_1");
        titleMap6.put("pid", "22");
        titleMap6.put("content", "角色1");
        titleMap6.put("fielName", "u_role");
        Map<String, String> titleMap7 = new HashMap<String, String>();
        titleMap7.put("id", "22_2");
        titleMap7.put("pid", "22");
        titleMap7.put("content", "部门1");
        titleMap7.put("fielName", "u_dep");
        titleList.add(titleMap);
        titleList.add(titleMap1);
        titleList.add(titleMap2);
        titleList.add(titleMap3);
        titleList.add(titleMap4);
        titleList.add(titleMap5);
        titleList.add(titleMap6);
        titleList.add(titleMap7);
//        // 单级的 行内数据
       List<Map<String, String>> rowList = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            Map m = new HashMap<String, String>();
//            m.put("u_login_id", "登录名" + i);
//            m.put("u_name", "张三" + i);
//            m.put("u_role", "角色" + i);
//            m.put("u_dep", "部门" + i);
//            m.put("u_type", "用户类型" + i);
//            rowList.add(m);
//        }
        ExcelTool excelTool = new ExcelTool("List<Map>数据 多级表头表格", 20, 20);
        List<Column> titleData = excelTool.columnTransformer(titleList, "id", "pid", "content", "fielName", "0");
        excelTool.exportExcel(titleData, rowList, "D://outExcel.xls", true, false);


    }
}
