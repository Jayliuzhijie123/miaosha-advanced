package com.miaosha.service.impl;

import com.miaosha.constant.SeckillConstant;
import com.miaosha.dao.*;
import com.miaosha.exception.SeckillException;
import com.miaosha.model.*;
import com.miaosha.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by lzj on 2019/03/25
 */
@Service("goodsService")
@Slf4j
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

    @Resource
    private PromotionSeckillDao promotionSeckillDao;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate;

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

    @Override
    public void purchaseGoods(Integer goodsId, String userId, Integer num) {
        Goods goods = selectGoodsById(goodsId);
        if (Objects.isNull(goods)) {
            throw new SeckillException("goodsId: " + goodsId + ", 商品不存在");
        }

        PromotionSeckill promotionSeckill = promotionSeckillDao.findByGoodsId(goodsId);
        if (Objects.isNull(promotionSeckill)) {
            throw new SeckillException("goodsId: " + goodsId + ", 没有秒杀信息");
        }

        Integer status = promotionSeckill.getStatus();
        if (status == SeckillConstant.UNSTART) {
            throw new SeckillException("goodsId: " + goodsId + ", 秒杀活动未开始");
        }

        if (status == SeckillConstant.END) {
            throw new SeckillException("goodsId: " + goodsId + ", 秒杀活动已结束");
        }

        Long psId = promotionSeckill.getPsId();
        if (redisTemplate.opsForSet().isMember(SeckillConstant.REDIS_USER_KEY + psId, userId)) {
            //说明用户已获得抢购资格
            throw new SeckillException("userId: " + userId + ", 已获得抢购资格，无法再次抢购");
        }

        Object goodsId1 = redisTemplate.opsForList().leftPop(SeckillConstant.REDIS_GOODS_KEY + psId);
        if (Objects.isNull(goodsId1)) {
            throw new SeckillException("goodsId: " + goodsId1 + ", 商品已抢完");
        }

        redisTemplate.opsForSet().add(SeckillConstant.REDIS_USER_KEY + psId, userId);
        log.info("userId: " + userId + ", 获得了抢购资格");
    }

    @Override
    public String sendMsgToQueue(String userId) {
//        log.info("向队列发送消息");

        //订单信息
        Map<String, Object> map = new HashMap<>(16);
        map.put("userId", userId);
        String orderNo = UUID.randomUUID().toString();
        map.put("orderNo", orderNo);

        //还可附加额外订单信息，此处略。。。

        rabbitTemplate.convertAndSend("exchange-order", null, map);
        return orderNo;
    }

}
