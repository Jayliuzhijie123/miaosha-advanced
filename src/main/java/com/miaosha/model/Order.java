package com.miaosha.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_order
 * @author 
 */
public class Order implements Serializable {
    private Integer orderId;

    /**
     * 订单业务编号
     */
    private String orderNo;

    /**
     * 0-已创建 1-已支付 3-已发货 4-已收货 5-已评价
     */
    private Integer orderStatus;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 收件人
     */
    private String recvName;

    /**
     * 收货地址
     */
    private String recvAddress;

    /**
     * 联系电话
     */
    private String recvMobile;

    /**
     * 邮费
     */
    private Float postage;

    /**
     * 实付款
     */
    private Float amout;

    /**
     * 订单创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 3911689606367845752L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public String getRecvMobile() {
        return recvMobile;
    }

    public void setRecvMobile(String recvMobile) {
        this.recvMobile = recvMobile;
    }

    public Float getPostage() {
        return postage;
    }

    public void setPostage(Float postage) {
        this.postage = postage;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRecvName() == null ? other.getRecvName() == null : this.getRecvName().equals(other.getRecvName()))
            && (this.getRecvAddress() == null ? other.getRecvAddress() == null : this.getRecvAddress().equals(other.getRecvAddress()))
            && (this.getRecvMobile() == null ? other.getRecvMobile() == null : this.getRecvMobile().equals(other.getRecvMobile()))
            && (this.getPostage() == null ? other.getPostage() == null : this.getPostage().equals(other.getPostage()))
            && (this.getAmout() == null ? other.getAmout() == null : this.getAmout().equals(other.getAmout()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRecvName() == null) ? 0 : getRecvName().hashCode());
        result = prime * result + ((getRecvAddress() == null) ? 0 : getRecvAddress().hashCode());
        result = prime * result + ((getRecvMobile() == null) ? 0 : getRecvMobile().hashCode());
        result = prime * result + ((getPostage() == null) ? 0 : getPostage().hashCode());
        result = prime * result + ((getAmout() == null) ? 0 : getAmout().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", userId=").append(userId);
        sb.append(", recvName=").append(recvName);
        sb.append(", recvAddress=").append(recvAddress);
        sb.append(", recvMobile=").append(recvMobile);
        sb.append(", postage=").append(postage);
        sb.append(", amout=").append(amout);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}