package com.miaosha.service.impl;

import com.miaosha.dao.OrderDao;
import com.miaosha.model.Order;
import com.miaosha.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lzj on 2019/02/18
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;


    @Override
    public Order selectOrderByOrderNo(String orderNo) {
        return orderDao.selectByOrderNo(orderNo);
    }
}
