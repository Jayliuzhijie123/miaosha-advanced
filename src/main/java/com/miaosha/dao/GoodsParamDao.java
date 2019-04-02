package com.miaosha.dao;

import com.miaosha.model.GoodsParam;

import java.util.List;

public interface GoodsParamDao {
    int deleteByPrimaryKey(Integer gpId);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Integer gpId);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);

    List<GoodsParam> findParams(Integer gid);
}