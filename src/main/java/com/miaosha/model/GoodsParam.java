package com.miaosha.model;

import java.io.Serializable;

/**
 * t_goods_param
 * @author 
 */
public class GoodsParam implements Serializable {
    private Integer gpId;

    private String gpParamName;

    private String gpParamValue;

    private Integer goodsId;

    private Integer gpOrder;

    private static final long serialVersionUID = 1L;

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public String getGpParamName() {
        return gpParamName;
    }

    public void setGpParamName(String gpParamName) {
        this.gpParamName = gpParamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Integer gpOrder) {
        this.gpOrder = gpOrder;
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
        GoodsParam other = (GoodsParam) that;
        return (this.getGpId() == null ? other.getGpId() == null : this.getGpId().equals(other.getGpId()))
            && (this.getGpParamName() == null ? other.getGpParamName() == null : this.getGpParamName().equals(other.getGpParamName()))
            && (this.getGpParamValue() == null ? other.getGpParamValue() == null : this.getGpParamValue().equals(other.getGpParamValue()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGpOrder() == null ? other.getGpOrder() == null : this.getGpOrder().equals(other.getGpOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGpId() == null) ? 0 : getGpId().hashCode());
        result = prime * result + ((getGpParamName() == null) ? 0 : getGpParamName().hashCode());
        result = prime * result + ((getGpParamValue() == null) ? 0 : getGpParamValue().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGpOrder() == null) ? 0 : getGpOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gpId=").append(gpId);
        sb.append(", gpParamName=").append(gpParamName);
        sb.append(", gpParamValue=").append(gpParamValue);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", gpOrder=").append(gpOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}