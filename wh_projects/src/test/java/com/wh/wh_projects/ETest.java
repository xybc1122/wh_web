package com.wh.wh_projects;

import com.wh.utils.excel.Column;
import com.wh.utils.excel.ExcelTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ETest
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/3 15:01
 **/
public class ETest {


    public static void main(String[] args) throws Exception {

//
//        //单级的表头
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
////        //单级的 行内数据
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
        //TODO 这里后面都要去封装
        List<String> titleList = new ArrayList<>();
        titleList.add("账号");
        titleList.add("单据日期");
        titleList.add("单据号");
        titleList.add("recordNum");
        titleList.add("运送时间");
        titleList.add("FNSKU");
        titleList.add("数量");
        titleList.add("跟踪号");
        titleList.add("规格");
        ExcelTool excelTool = new ExcelTool("fba导入模板", 15, 20);
        List<Column> titleData = excelTool.columnTransformer(titleList);
        excelTool.exportExcel(titleData, new ArrayList(), "D://FBA导入.xlsx", true, false);


//        List<Map> 数据 多级表头, 数据如下:
//        登录名 姓名 aa
//        角色 部门
//        List<Map<String, String>> titleList = new ArrayList<>();
//        Map<String, String> titleMap = new HashMap<>();
//        titleMap.put("id", "11");
//        titleMap.put("pid", "0");
//        titleMap.put("content", "账号");
//        titleMap.put("fielName", "u_login_id");
//        Map<String, String> titleMap1 = new HashMap<>();
//        titleMap1.put("id", "1");
//        titleMap1.put("pid", "0");
//        titleMap1.put("content", "站点");
//        titleMap1.put("fielName", "u_name");
//        Map<String, String> titleMap2 = new HashMap<>();
//        titleMap2.put("id", "2");
//        titleMap2.put("pid", "3");
//        titleMap2.put("content", "FNSKU");
//        titleMap2.put("fielName", "fnsku");
//        Map<String, String> titleMap3 = new HashMap<>();
//        titleMap3.put("id", "3");
//        titleMap3.put("pid", "0");
//        titleMap3.put("content", "子单据");
//        titleMap3.put("fielName", null);
//        Map<String, String> titleMap4 = new HashMap<>();
//        titleMap4.put("id", "77");
//        titleMap4.put("pid", "0");
//        titleMap4.put("content", "单据日期");
//        titleMap4.put("fielName", "u_dep");
//
//        Map<String, String> titleMap5 = new HashMap<>();
//        titleMap5.put("id", "22");
//        titleMap5.put("pid", "0");
//        titleMap5.put("content", "单据号");
//        titleMap5.put("fielName", "danjuhao");
//
//        Map<String, String> titleMap6 = new HashMap<>();
//        titleMap6.put("id", "6");
//        titleMap6.put("pid", "3");
//        titleMap6.put("content", "跟踪号");
//        titleMap6.put("fielName", "gzh");
//
//        Map<String, String> titleMap7 = new HashMap<>();
//        titleMap7.put("id", "7");
//        titleMap7.put("pid", "3");
//        titleMap7.put("content", "规格");
//        titleMap7.put("fielName", "gg");
//
//
//
//
//        Map<String, String> titleMap8 = new HashMap<>();
//        titleMap8.put("id", "22_1");
//        titleMap8.put("pid", "3");
//        titleMap8.put("content", "数量");
//        titleMap8.put("fielName", "u_role");
//        Map<String, String> titleMap9 = new HashMap<>();
//        titleMap9.put("id", "88");
//        titleMap9.put("pid", "0");
//        titleMap9.put("content", "recordNum");
//        titleMap9.put("fielName", "u_role");


//        titleList.add(titleMap);
//        titleList.add(titleMap1);
//        titleList.add(titleMap2);
//        titleList.add(titleMap3);
//        titleList.add(titleMap4);
//        titleList.add(titleMap5);
//        titleList.add(titleMap6);
//        titleList.add(titleMap7);
//        titleList.add(titleMap8);
//
//        titleList.add(titleMap9);

        // 单级的 行内数据
        //   List<Map<String, String>> rowList = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            Map m = new HashMap<String, String>();
//            m.put("u_login_id", "登录名" + i);
//            m.put("u_name", "张三" + i);
//            m.put("fnsku", "角色" + i);
//            m.put("u_dep", "部门" + i);
//            m.put("u_type", "用户类型" + i);
//            rowList.add(m);
//        }
//        ExcelTool excelTool = new ExcelTool("多级表头", 20, 20);
//        List<Column> titleData = excelTool.columnTransformer(titleList, "id", "pid", "content", "fielName", "0");
//        excelTool.exportExcel(titleData, rowList, "D://outExcel.xlsx", true, false);
//
//        ExcelTool excelTool1 = new ExcelTool();
//        int i = excelTool1.hasSheetCount("D://outExcel.xls");
//        // System.out.println(excelTool1.hasSheetCount("D://FBA导入.xlsx"));
//        List<Map<String, String>> excelMapVal = excelTool1.getExcelValues("D://outExcel.xls", i);
//        System.out.println(excelMapVal);
    }
}
