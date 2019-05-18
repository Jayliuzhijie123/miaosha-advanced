package com.miaosha.service;


import com.miaosha.model.Order;

/**
 * Created by lzj on 2019/02/18
 */
public interface OrderService {
    Order selectOrderByOrderNo(String orderNo);
}
