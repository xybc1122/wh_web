package com.wh.entity.position;

/**
 * 倉庫
 */
public class WhPosition {
    private int id;
    /**
     * 仓库简码
     */
    private String positionName;

    private String asin;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public WhPosition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public WhPosition(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }
}
