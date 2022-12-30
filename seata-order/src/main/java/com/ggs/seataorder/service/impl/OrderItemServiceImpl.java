package com.ggs.seataorder.service.impl;

import com.ggs.seataorder.entity.OrderItem;
import com.ggs.seataorder.mapper.OrderItemMapper;
import com.ggs.seataorder.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单项 服务实现类
 * </p>
 *
 * @author starbug
 * @since 2022-12-29
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
