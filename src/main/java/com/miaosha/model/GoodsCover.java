package com.miaosha.model;

import java.io.Serializable;

/**
 * t_goods_cover
 * @author 
 */
public class GoodsCover implements Serializable {
    private Integer gcId;

    private Integer goodsId;

    private String gcPicUrl;

    private String gcThumbUrl;

    private Integer gcOrder;

    private static final long serialVersionUID = 1L;

    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGcPicUrl() {
        return gcPicUrl;
    }

    public void setGcPicUrl(String gcPicUrl) {
        this.gcPicUrl = gcPicUrl;
    }

    public String getGcThumbUrl() {
        return gcThumbUrl;
    }

    public void setGcThumbUrl(String gcThumbUrl) {
        this.gcThumbUrl = gcThumbUrl;
    }

    public Integer getGcOrder() {
        return gcOrder;
    }

    public void setGcOrder(Integer gcOrder) {
        this.gcOrder = gcOrder;
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
        GoodsCover other = (GoodsCover) that;
        return (this.getGcId() == null ? other.getGcId() == null : this.getGcId().equals(other.getGcId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGcPicUrl() == null ? other.getGcPicUrl() == null : this.getGcPicUrl().equals(other.getGcPicUrl()))
            && (this.getGcThumbUrl() == null ? other.getGcThumbUrl() == null : this.getGcThumbUrl().equals(other.getGcThumbUrl()))
            && (this.getGcOrder() == null ? other.getGcOrder() == null : this.getGcOrder().equals(other.getGcOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGcId() == null) ? 0 : getGcId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGcPicUrl() == null) ? 0 : getGcPicUrl().hashCode());
        result = prime * result + ((getGcThumbUrl() == null) ? 0 : getGcThumbUrl().hashCode());
        result = prime * result + ((getGcOrder() == null) ? 0 : getGcOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gcId=").append(gcId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", gcPicUrl=").append(gcPicUrl);
        sb.append(", gcThumbUrl=").append(gcThumbUrl);
        sb.append(", gcOrder=").append(gcOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}