package com.wh.entity.order;

/**
 * @author yyk
 * @date 2019/7/11 14:34
 * @description 订单详情表
 */
public class WhOrderItems {
    private int id;
    /**
     * 主订单id
     */
    private int orderId;
    /**
     * 产品价格
     */
    private double itemPrice;
    /**
     *sku
     */
    private String skuAsin;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 数量
     */
    private int amount;

    public WhOrderItems() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSkuAsin() {
        return skuAsin;
    }

    public void setSkuAsin(String skuAsin) {
        this.skuAsin = skuAsin;
    }

    public WhOrderItems(int id, int orderId, double itemPrice, String skuAsin) {
        this.id = id;
        this.orderId = orderId;
        this.itemPrice = itemPrice;
        this.skuAsin = skuAsin;
    }
}
