package com.wh.toos;


public interface Constants {
//    /**
//     * 保存webSocket连接对象 用户绑定
//     */
//    public static Map<Long, ChannelHandlerContext> onLineUserMap =
//            new ConcurrentHashMap<Long, ChannelHandlerContext>();
//
//    /**
//     * 保存webSocket 握手对象
//     */
//    public static Map<String, WebSocketServerHandshaker> webSocketHandShakerMap =
//            new ConcurrentHashMap<String, WebSocketServerHandshaker>();
//
//    /**
//     * 设置出库通知单 key
//     */
//    String SAVE_SHIP_NOTICE = "save_shipNotice";
//
//    /**
//     * 设置采购订单 key
//     */
//    String SAVE_PURCHASE_PO_ORDER = "save_purchasePoOrder";
//
    /**
     * redis设置新增用户的 key
     */
    String SAVE_USER_ROLE = "saveUserRole";
//
//    /**
//     * 设置外购入库 KEY
//     */
//    String SAVE_PURCHASE_ICB_STOCK = "save_purchase_icb_stock";
    /**
     * token
     */
    String SSO_TOKEN = "sso_token";
    /**
     * 最大等待时间 毫秒
     */
    long maxWait = 5000L;
    /**
     * 锁最大占用时间秒
     */
    long timeout = 20000L;
    /**
     * 管理员reid key
     */
    String ADMIN = "admin:";

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
     * 首次登陆返回状态码
     */

    String SELECT = "select";


}
