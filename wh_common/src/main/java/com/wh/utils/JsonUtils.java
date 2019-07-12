package com.wh.utils;

import com.google.gson.Gson;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wh.exception.LsException;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName JsonUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/28 13:40
 **/
public class JsonUtils {

    private static Gson gson = new Gson();

    /**
     * 响应数据给前端
     *
     * @param response
     */
    public static void sendJsonMsg(HttpServletResponse response, Object obj) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(gson.toJson(obj));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件 文件跟数据库对比失败 前端设置返回
     *
     * @param sqlHead
     * @param fileHead
     * @return
     */
    public static String json(List<String> sqlHead, List<String> fileHead) {
        JSONObject object = new JSONObject();
        object.put("sqlHead", sqlHead);
        object.put("fileHead", fileHead);
        return object.toJSONString();
    }

    /**
     * obj转换对象
     *
     * @param obj
     * @param tClass
     * @return
     */
    public static Object objConversion(Object obj, Class<?> tClass) {
        return JSON.parseObject(getJsonObj(obj), tClass);
    }

    /**
     * String 转换Array;
     *
     * @return
     */
    public static JSONArray getJsonArr(String str) {
        return JSONArray.parseArray(str);
    }

    /**
     * Object 转换Array;
     *
     * @return
     */
    public static JSONArray getJsonArr(Object obj) {
        return JSONArray.parseArray(getJsonObj(obj));
    }

    /**
     * Object 转换string
     *
     * @return
     */
    public static String getJsonObj(Object obj) {
        return JSONObject.toJSONString(obj);
    }

//    /**
//     * 成功  转换string
//     *
//     * @param msg
//     * @param type
//     * @return
//     */
//    public static String getJsonTypeSuccess(String msg, ChatType type) {
//
//        return JSONObject.toJSONString(JsonData.setResultTypeSuccess(msg, type.toString()));
//    }
//
//
//    /**
//     * 失败  转换string
//     *
//     * @param msg
//     * @param type
//     * @return
//     */
//    public static String getJsonTypeError(String msg, ChatType type) {
//
//        return JSONObject.toJSONString(JsonData.setResultTypeError(msg, type.toString()));
//    }

    /**
     * 新增返回消息
     *
     * @param result
     * @return
     */
    public static ResponseBase saveMsg(int result) {
        if (result != 0) {
            return JsonData.setResultSuccess("success");
        }
        return JsonData.setResultError("error");
    }


}
