package com.ggs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    String value;

    @PostMapping("/{name}")
    public String create(@PathVariable("name") String name) {
        System.out.println("product跨服务调用生产产品55555555" + name);
        return "product跨服务调用生产产品5555555555~~~" + value + "------" + name;
    }

}
