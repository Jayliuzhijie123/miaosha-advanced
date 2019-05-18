package com.miaosha.dao;

import com.miaosha.model.PromotionSeckill;

import java.util.List;

public interface PromotionSeckillDao {
    int deleteByPrimaryKey(Long psId);

    int insert(PromotionSeckill record);

    int insertSelective(PromotionSeckill record);

    PromotionSeckill selectByPrimaryKey(Long psId);

    List<PromotionSeckill> findUnStartSecKill();

    int updateByPrimaryKeySelective(PromotionSeckill record);

    int updateByPrimaryKey(PromotionSeckill record);

    PromotionSeckill findByGoodsId(Integer goodsId);
}