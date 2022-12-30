package com.ggs.seataorder.service;

import com.ggs.seataorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author starbug
 * @since 2022-12-29
 */
public interface OrderService extends IService<Order> {

    void payOrder(Integer productNum);

}
