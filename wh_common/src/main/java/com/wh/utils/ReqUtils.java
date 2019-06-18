package com.wh.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ReqUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/15 16:55
 **/
public class ReqUtils {


    /**
     * 获得用户ID
     *
     * @return
     */
    public static Long getUid() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            Integer uId = (Integer) request.getAttribute("uid");
            if (uId != null) {
                return uId.longValue();
            }
        }
        return null;
    }


    /**
     * 获得用户ID
     *
     * @return
     */
    public static String getUserName() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            String uName = (String) request.getAttribute("userName");
            if (StringUtils.isNotBlank(uName)) {
                return uName;
            }
        }
        return null;
    }

    /**
     * 获得用户角色ID
     *
     * @return
     */
    public static String getRoleId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            String rId = (String) request.getAttribute("rids");
            if (StringUtils.isNotBlank(rId)) {
                return rId;
            }
        }
        return null;
    }

    /**
     * 设置request
     *
     * @param request
     * @param uId
     * @param uName
     */
    public static void set(HttpServletRequest request, Long uId, String uName, String rId, String tenant) {
        request.setAttribute("uid", uId);
        request.setAttribute("userName", uName);
        request.setAttribute("rids", rId);
        request.setAttribute("tenant", tenant);
    }
}
