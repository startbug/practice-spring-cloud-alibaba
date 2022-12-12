package com.ggs.feign.fallback;

import com.ggs.feign.StockFeignService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StockFeignServiceFallback implements StockFeignService {


    @Override
    public String decrease(Long id) {
        return "stock异常，触发降级";
    }

}
