package com.wh.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
            Long uId = (Long) request.getAttribute("uid");
            if (uId != null) {
                return uId;
            }
        }
        return null;
    }
    /**
     * 获得租户标识
     *
     * @return
     */
    public static String getTenant() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            String tenant = (String) request.getAttribute("tenant");
            if (tenant != null) {
                return tenant;
            }
        }
        return null;
    }
    /**
     * 获得租户id
     *
     * @return
     */
    public static Integer getTid() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            Integer tId = (Integer) request.getAttribute("tid");
            if (tId != null) {
                return tId;
            }
        }
        return null;
    }

    /**
     * 获得用户名称
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
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    private static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int read = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (read == -1) {
                break;
            }
            i += read;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        if (buffer != null) {
            String charEncoding = request.getCharacterEncoding();
            if (charEncoding == null) {
                charEncoding = "UTF-8";
            }
            return new String(buffer, charEncoding);
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
    public static void set(HttpServletRequest request, Long uId, String uName, String rId, String tenant, Integer tId) {
        request.setAttribute("uid", uId);
        request.setAttribute("userName", uName);
        request.setAttribute("rids", rId);
        request.setAttribute("tenant", tenant);
        request.setAttribute("tid", tId);
    }
}
