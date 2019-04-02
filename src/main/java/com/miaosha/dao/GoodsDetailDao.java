package com.miaosha.dao;

import com.miaosha.model.GoodsDetail;

import java.util.List;

public interface GoodsDetailDao {
    int deleteByPrimaryKey(Integer gdId);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Integer gdId);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);

    List<GoodsDetail> selectByGoodsId(Integer gid);
}