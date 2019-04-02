package com.miaosha.service.impl;

import com.miaosha.dao.*;
import com.miaosha.model.*;
import com.miaosha.service.GoodsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lzj on 2019/03/25
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private GoodsCoverDao goodsCoverDao;

    @Resource
    private GoodsDetailDao goodsDetailDao;

    @Resource
    private GoodsParamDao goodsParamDao;

    @Resource
    private EvaluateDao evaluateDao;

    @Override
    @Cacheable(value = "goods", key = "#id")
    public Goods selectGoodsById(Integer id) {
        return goodsDao.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "covers", key = "#gid")
    public List<GoodsCover> findCovers(Integer gid) { return goodsCoverDao.selectByGoodsId(gid); }

    @Override
    @Cacheable(value = "details", key = "#gid")
    public List<GoodsDetail> findDetails(Integer gid) {
        return goodsDetailDao.selectByGoodsId(gid);
    }

    @Override
    @Cacheable(value = "params", key = "#gid")
    public List<GoodsParam> findParams(Integer gid) {
        return goodsParamDao.findParams(gid);
    }

    @Override
    public List<Integer> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> findLast5M() {
        return goodsDao.findLast5M();
    }

    @Override
    public List<Evaluate> findEvaluateByGoodsId(Long goodsId) {
        return evaluateDao.findEvaluateByGoodsId(goodsId);
    }

}
