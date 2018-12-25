package com.xxxx.order.service.impl;

import com.xxxx.order.dataobject.OrderMaster;
import com.xxxx.order.dto.OrderDTO;
import com.xxxx.order.enums.OrderStatusEnum;
import com.xxxx.order.enums.PayStatusEnum;
import com.xxxx.order.repository.OrderDetailRepository;
import com.xxxx.order.repository.OrderMasterRepository;
import com.xxxx.order.service.OrderService;
import com.xxxx.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO 查询商品信息(调用商品服务)
        //TODO 计算总价
        //TODO 扣库存(调用商品服务)

        // 订单入库
        orderDTO.setOrderId(KeyUtil.getUniqueKey());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
