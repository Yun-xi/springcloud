package com.xxxx.order.repository;

import com.mysql.jdbc.StringUtils;
import com.xxxx.order.OrderApplicationTests;
import com.xxxx.order.dataobject.OrderMaster;
import com.xxxx.order.enums.OrderStatusEnum;
import com.xxxx.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("13333333333");
        orderMaster.setBuyerAddress("泰山街道");
        orderMaster.setBuyerOpenid("11111");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}