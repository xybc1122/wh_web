package com.wh.toos;

import com.wh.config.ConstantsConfig;

/**
 * @ClassName StaticVariable
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 9:28
 **/
public class StaticVariable {
    /**
     * token
     */
    public static String SSO_TOKEN;

    /**
     * 调拨key前缀
     */
    public static String DB;

    /**
     * 调拨条目表id前缀
     */
    public static String DB_E_ID;
    /**
     * fba key 前缀
     */
    public static String FBA;
    /**
     * fba条目表id前缀
     */
    public static String FBA_E_ID;

    /**
     * 接口幂等token
     */
    public static String IDE_TOKEN;


    /**
     * 管理员reid key
     */
    public static String ADMIN;


    /**
     * 文件上传存放地址
     */
    public static String SAVE_FILE_PATH;


    /**
     * 模板路径
     */
    public static String FILE_TEMPLATE;

    /**
     * 加载配置文件
     */
    public static void setParameter(ConstantsConfig constantsConfig) {
        SSO_TOKEN = constantsConfig.getSsoToken();
        ADMIN = constantsConfig.getAdmin();
        DB = constantsConfig.getDb();
        FBA = constantsConfig.getFba();
        IDE_TOKEN = constantsConfig.getIdeToken();
        DB_E_ID = constantsConfig.getDbEId();
        FBA_E_ID = constantsConfig.getFbaEId();
        SAVE_FILE_PATH = constantsConfig.getSaveFilePath();
        FILE_TEMPLATE = constantsConfig.getFileTemplate();
    }
}
