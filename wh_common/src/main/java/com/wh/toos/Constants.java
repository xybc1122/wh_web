package com.wh.toos;


/**
 * @ClassName Constants
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/29 9:14
 * 一些常量配置
 **/
public interface Constants {

    /**
     * redis设置新增用户的 key
     */
    String SAVE_USER = "save_user";

    /**
     * redis设置新增用户的 key
     */
    String SAVE_TENANT = "save_tenant";
    /**
     * 设置调拨出库的 KEY
     */
    String TRANSFER_KE = "transfer_ke";

    /**
     * 开发者超级管理员 redis key
     */
    String SUPER_ADMIN = "super-admin";

    /**
     * 开发者超级管理员 redis key
     */
    String PERMISSION = "permission";

    /**
     * 幂等key 到期时间
     */
    long EXPIRE_TIME_MINUTE = 60 * 3L;


    /**
     * 最大等待时间 毫秒
     */
    long maxWait = 5000L;
    /**
     * 锁最大占用时间秒
     */
    long timeout = 20000L;


    /**
     * 响应请求成功
     */
    String HTTP_RES_CODE_200_VALUE = "success";
    /**
     * 响应请求成功code
     */
    Integer HTTP_RES_CODE_200 = 200;
    /**
     * 系统错误
     */
    Integer HTTP_RES_CODE = -1;

    /**
     * 请求响应错误
     */
    Integer HTTP_RESP_CODE = -2;

    /**
     * 幂等请求aop  header类型
     */
    String IDEMPOTENT_CHECK_HEADER = "header";

//权限一些操作配置
    /**
     * 查看
     */
    String VIEW = "GET";
    /**
     * 新增
     */
    String SAVE = "POST";
    /**
     * 修改
     */
    String MODIFY = "PUT";

    /**
     * 删除
     */
    String DELETE = "DELETE";

    /**
     * feign请求php接口地址
     */
    String PHP_ADD = "http://192.168.1.232:85";
    /**
     * feign请求php名称
     */
    String PHP_NAME = "php";


}
