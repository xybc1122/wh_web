package com.wh.entity.upload;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 上传存储对象
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-01
 */
public class WhUserUpload extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 记录id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 文件唯一名称
     */
    private String uuidName;

    /**
     * 上传文件名字
     */
    private String name;

    /**
     * 上传服务器路径
     */
    private String filePath;

    /**
     * 上传状态 0代表成功,1代表失败
     */
    private Integer uStatus;

    /**
     * 处理 0代表成功,1代表失败
     */
    private Integer dwStatus;

    /**
     * ftp图片url
     */
    private String url;


    /**
     * 处理记录信息数据集合
     */
    private List<WhUserUpload> uploadSuccessList;


    public WhUserUpload() {

    }

    public WhUserUpload(Long uid, String uuidName, String name, String filePath, Integer uStatus, String uName, String msg) {
        super.setRemark(msg);
        super.setCreate(uName);
        this.uid = uid;
        this.uuidName = uuidName;
        this.name = name;
        this.filePath = filePath;
        this.uStatus = uStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WhUserUpload> getUploadSuccessList() {
        return uploadSuccessList;
    }

    public void setUploadSuccessList(List<WhUserUpload> uploadSuccessList) {
        this.uploadSuccessList = uploadSuccessList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public Integer getDwStatus() {
        return dwStatus;
    }

    public void setDwStatus(Integer dwStatus) {
        this.dwStatus = dwStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
