package com.miaosha.constant;

/**
 * Created by lzj on 2019/04/05
 *
 * 秒杀常量类
 */
public class SeckillConstant {
    /**
     * 用户可抢购的商品数量
     */
    public static final int NUM = 1;

    /**
     * 秒杀未开启
     */
    public static final int UNSTART = 0;

    /**
     * 秒杀进行中
     */
    public static final int START = 1;

    /**
     * 秒杀已结束
     */
    public static final int END = 2;

    /**
     * 商品限购数量
     */
    public static final String REDIS_GOODS_KEY = "seckill:count:";

    /**
     * 可购买活动商品的用户
     */
    public static final String REDIS_USER_KEY = "seckill:user:";
}
