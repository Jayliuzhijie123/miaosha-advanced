package com.miaosha.service;

import com.miaosha.model.*;

import java.util.List;

/**
 * Created by lzj on 2019/03/25
 */
public interface GoodsService {
    Goods selectGoodsById(Integer id);

    List<GoodsCover> findCovers(Integer gid);

    List<GoodsDetail> findDetails(Integer gid);

    List<GoodsParam> findParams(Integer gid);

    List<Integer> findAll();

    List<Goods> findLast5M();

    List<Evaluate> findEvaluateByGoodsId(Long goodsId);
}
