package com.ggs.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.feign.ProductFeignService;
import com.ggs.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/place")
//    public String place() {
//        ResponseEntity<String> entity = restTemplate.postForEntity("http://nacos-stock/stock/decrease", null, String.class);
//        String body = entity.getBody();
//        System.out.println("stock:" + body);
//        System.out.println("下单成功....");
//        return "下单成功响应" + body;
//    }

    @Autowired
    private StockFeignService stockFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping("/place")
    public String place(Long id, String name) {
        String decrease = stockFeignService.decrease(id);
//        String s = productFeignService.create(name);
        System.out.println("stock:" + decrease);
        System.out.println("下单成功....");
        return "下单成功响应" + decrease + "----------|||-";
    }

    /**
     * 热点规则，必须使用@SentinelResource
     *
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    @SentinelResource(value = "getById", blockHandler = "hotBlockHandler")
    public String getById(@PathVariable("id") Integer id) {
        System.out.println("正常访问");
        return "正常访问!!!";
    }

    public String hotBlockHandler(@PathVariable("id") Integer id, BlockException e) {
        return "热点异常处理";
    }

}
