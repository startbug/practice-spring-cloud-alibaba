package com.ggs.seatastock.controller;


import com.ggs.seatastock.entity.common.CommonResponse;
import com.ggs.seatastock.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品库存 前端控制器
 * </p>
 *
 * @author starbug
 * @since 2022-12-27
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/seatastock/product-stock")
public class ProductStockController {

    private final ProductStockService productStockService;

    @Value("${custom.user.open-id}")
    private String openId;

    @PostMapping("/decrease")
    public CommonResponse decrease(@RequestParam("productId") Integer productId, @RequestParam("number") Integer number) {
        boolean flag = productStockService.decrease(productId, number);
        System.out.println("openId-------------" + openId);
        return flag ? CommonResponse.ok(null) : CommonResponse.fail("扣减库存失败");
    }

}
