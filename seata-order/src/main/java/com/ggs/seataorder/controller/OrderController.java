package com.ggs.seataorder.controller;


import com.ggs.seataorder.entity.common.CommonResponse;
import com.ggs.seataorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author starbug
 * @since 2022-12-29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/seataorder/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/pay-order")
    public CommonResponse payOrder(@RequestParam("productNum") Integer productNum) {
        orderService.payOrder(productNum);
        return CommonResponse.ok("成功");
    }


}
