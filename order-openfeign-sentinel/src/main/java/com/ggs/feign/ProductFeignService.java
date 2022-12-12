package com.ggs.feign;

import com.ggs.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 指定日志级别configuration = {FeignConfig.class}
 */
@FeignClient(name = "nacos-product", path = "/product")
//@FeignClient(name = "nacos-product", path = "/product", configuration = {FeignConfig.class})
public interface ProductFeignService {

    @PostMapping("/{name}")
    String create(@PathVariable("name") String name);

}
