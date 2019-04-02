package com.miaosha.model;

import java.io.Serializable;

/**
 * t_goods_detail
 * @author 
 */
public class GoodsDetail implements Serializable {
    private Integer gdId;

    private Integer goodsId;

    private String gdPicUrl;

    private Integer gdOrder;

    private static final long serialVersionUID = 1L;

    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGdPicUrl() {
        return gdPicUrl;
    }

    public void setGdPicUrl(String gdPicUrl) {
        this.gdPicUrl = gdPicUrl;
    }

    public Integer getGdOrder() {
        return gdOrder;
    }

    public void setGdOrder(Integer gdOrder) {
        this.gdOrder = gdOrder;
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
        GoodsDetail other = (GoodsDetail) that;
        return (this.getGdId() == null ? other.getGdId() == null : this.getGdId().equals(other.getGdId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGdPicUrl() == null ? other.getGdPicUrl() == null : this.getGdPicUrl().equals(other.getGdPicUrl()))
            && (this.getGdOrder() == null ? other.getGdOrder() == null : this.getGdOrder().equals(other.getGdOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGdId() == null) ? 0 : getGdId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGdPicUrl() == null) ? 0 : getGdPicUrl().hashCode());
        result = prime * result + ((getGdOrder() == null) ? 0 : getGdOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gdId=").append(gdId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", gdPicUrl=").append(gdPicUrl);
        sb.append(", gdOrder=").append(gdOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}