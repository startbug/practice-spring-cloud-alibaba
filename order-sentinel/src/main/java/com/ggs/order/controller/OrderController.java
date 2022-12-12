package com.ggs.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class OrderController {


// 测试流控模式:链路 begin -----------------------------------------------------------------
//    spring.cloud.sentinel.web-context-unify
//    流控模式:链路，需要指定为false，让sentinel维护调用链路树，默认是收敛的
    @Autowired
    private UserService userService;

    @GetMapping("/test1")
    public String getUser1() {
        return userService.getUser();
    }

    @GetMapping("/test2")
    public String getUser2() {
        return userService.getUser();
    }

// 测试流控模式:链路 end -----------------------------------------------------------------


    // 测试流控模式:关联 begin -----------------------------------------------------------------
    // jmeter测试脚本:关联流控.jmx
    // 当大量创建订单时，就去限流订单查询接口
    @GetMapping("/add")
    public String add() {
        System.out.println("创建订单~~~");
        return "创建订单";
    }

    @GetMapping("/get")
    public String get() {
        System.out.println("查询订单~~");
        return "查询订单";
    }

// 测试流控模式:关联 end -----------------------------------------------------------------

    // ----------------------------------------------------------------

    @GetMapping("/hello")
//    @SentinelResource(value = "xxxxxxxxxxx", blockHandler = "helloBlockHandler")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/flow")
    public String flow() {
        return "flow flow flow";
    }

    @GetMapping("/flowThread")
//    @SentinelResource(value = "flowThreadzzz", blockHandler = "flowThreadBlockHandler")
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "flowThread flowThread ----------------";
    }

    public String flowThreadBlockHandler(BlockException e) {
        return "线程数流控,msg:" + e.getLocalizedMessage();
    }

    public String helloBlockHandler(BlockException e) {
        return "被流控了,msg:" + e.getLocalizedMessage();
    }

}
