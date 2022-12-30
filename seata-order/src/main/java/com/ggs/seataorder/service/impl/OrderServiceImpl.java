package com.ggs.seataorder.service.impl;

import com.ggs.seataorder.entity.Order;
import com.ggs.seataorder.entity.OrderItem;
import com.ggs.seataorder.mapper.OrderMapper;
import com.ggs.seataorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author starbug
 * @since 2022-12-29
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public void payOrder(Integer productNum) {
        Order order = Order.builder()
                .orderAmount(1000)
                .orderNo(UUID.randomUUID().toString().replaceAll("-", ""))
                .subject("测试")
                .productNum(productNum)
                .build();
        OrderItem orderItem = new OrderItem();
    }

}
