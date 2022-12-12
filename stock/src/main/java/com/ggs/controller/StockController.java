package com.ggs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String value;

    @PostMapping("/{id}")
    public String decrease(@PathVariable("id") Long id) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(4);
        int i = 1 / 0;
        System.out.println("跨服务调用扣减库存22222222" + id);
        return "扣减库存222222222~~~" + value + "------" + (id * 10);
    }

}
