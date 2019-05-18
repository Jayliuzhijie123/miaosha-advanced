package com.miaosha.exception;

/**
 * Created by lzj on 2019/04/05
 *
 * 秒杀异常类
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }
}
