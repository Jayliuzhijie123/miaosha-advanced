package com.miaosha.dao;

import com.miaosha.model.Evaluate;

import java.util.List;

public interface EvaluateDao {
    int deleteByPrimaryKey(Long evaluateId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Long evaluateId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<Evaluate> findEvaluateByGoodsId(Long goodsId);
}