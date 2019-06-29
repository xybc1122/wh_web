package com.wh.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.out_library.transfer.entry.WhTransferOutLibraryEntry;

import java.util.List;

/**
 * @ClassName TransferDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/28 8:50
 **/
public class TransferDto {


    /**
     * 调拨单号
     */
    private String tNumber;

    /**
     * 移出仓
     */
    private Integer rWarId;

    /**
     * 移入仓
     */
    private Integer mIWarId;

    /**
     * 运单号
     */
    private String wayNumber;
    /**
     * 调拨类型
     */
    private Integer type;

    /**
     * 条目表
     */
    private List<TransferEntryDto> entry;

    public String getWayNumber() {
        return wayNumber;
    }

    public void setWayNumber(String wayNumber) {
        this.wayNumber = wayNumber;
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

    public List<TransferEntryDto> getEntry() {
        return entry;
    }

    public void setEntry(List<TransferEntryDto> entry) {
        this.entry = entry;
    }
}
