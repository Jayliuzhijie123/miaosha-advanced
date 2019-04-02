package com.miaosha.dao;

import com.miaosha.model.GoodsCover;

import java.util.List;

public interface GoodsCoverDao {
    int deleteByPrimaryKey(Integer gcId);

    int insert(GoodsCover record);

    int insertSelective(GoodsCover record);

    GoodsCover selectByPrimaryKey(Integer gcId);

    int updateByPrimaryKeySelective(GoodsCover record);

    int updateByPrimaryKey(GoodsCover record);

    List<GoodsCover> selectByGoodsId(Integer gId);
}