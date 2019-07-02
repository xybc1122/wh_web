package com.wh.entity.out.library.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.out.library.transfer.entry.WhTransferOutLibraryEntry;
import com.wh.entity.parent.ParentConfTable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-25
 */
public class WhTransferOutLibrary extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标识ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 调拨单号
     */
    private String tNumber;

    /**
     * 移出仓
     */
    @NotNull(message = "移出仓不能为空")
    private Integer rWarId;

    /**
     * 移入仓
     */
    @NotNull(message = "移入仓不能为空")
    private Integer mIWarId;

    /**
     * 调拨类型
     */
    private Integer type;

    /**
     * 操作状态
     */
    private Integer status;

    /**
     * 运单号
     */
    @NotBlank(message = "运单号不能为空")
    private String wayNumber;


    /**
     * 条目表
     */
    @TableField(exist = false)
    @Size(min = 1, message = "is null or length =0")
    @Valid
    private List<WhTransferOutLibraryEntry> entry;
    /**
     * 移出仓库名
     */
    @TableField(exist = false)
    private String rWarName;
    /**
     * 移入仓库名
     */
    @TableField(exist = false)
    private String mIWarName;


    public String getrWarName() {
        return rWarName;
    }

    public void setrWarName(String rWarName) {
        this.rWarName = rWarName;
    }

    public String getmIWarName() {
        return mIWarName;
    }

    public void setmIWarName(String mIWarName) {
        this.mIWarName = mIWarName;
    }

    public WhTransferOutLibrary() {

    }

    public WhTransferOutLibrary(String tNumber) {
        this.tNumber = tNumber;
    }

    public List<WhTransferOutLibraryEntry> getEntry() {
        return entry;
    }

    public void setEntry(List<WhTransferOutLibraryEntry> entry) {
        this.entry = entry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public Integer getrWarId() {
        return rWarId;
    }

    public void setrWarId(Integer rWarId) {
        this.rWarId = rWarId;
    }

    public Integer getmIWarId() {
        return mIWarId;
    }

    public void setmIWarId(Integer mIWarId) {
        this.mIWarId = mIWarId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWayNumber() {
        return wayNumber;
    }

    public void setWayNumber(String wayNumber) {
        this.wayNumber = wayNumber;
    }
}
