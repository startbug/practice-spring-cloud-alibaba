package com.ggs.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "nacos-stock", path = "/stock")
public interface StockFeignService {

    @PostMapping("/{id}")
    String decrease(@PathVariable("id") Long id);

}
