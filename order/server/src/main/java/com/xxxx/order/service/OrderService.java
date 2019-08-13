package com.xxxx.order.service;

import com.xxxx.order.dto.OrderDTO;

/**
 * Created by xieyaqi
 * 2017-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
