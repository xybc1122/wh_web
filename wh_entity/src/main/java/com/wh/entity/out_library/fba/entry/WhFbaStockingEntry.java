package com.wh.entity.out_library.fba.entry;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 * fbs 备货 条目表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-21
 */
public class WhFbaStockingEntry extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 标识ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 产品sku
     */
    private String sku;

    /**
     * fn_sku
     */
    private String fnSku;

    /**
     * 名称
     */
    private String fseName;

    /**
     * 备货数量
     */
    private Integer sQuantity;

    /**
     * fba备货id
     */
    private Long fsId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku;
    }

    public String getFseName() {
        return fseName;
    }

    public void setFseName(String fseName) {
        this.fseName = fseName;
    }

    public Integer getsQuantity() {
        return sQuantity;
    }

    public void setsQuantity(Integer sQuantity) {
        this.sQuantity = sQuantity;
    }

    public Long getFsId() {
        return fsId;
    }

    public void setFsId(Long fsId) {
        this.fsId = fsId;
    }
}
