package com.ggs.sentinelnew.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ggs.sentinelnew.common.R;
import com.ggs.sentinelnew.entity.User;
import com.ggs.sentinelnew.sentinel.block.UserBlockHandler;
import com.ggs.sentinelnew.sentinel.exception.UserExceptionHandler;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>@SentinelResource注解详解</p>
 * <p>https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81</p>
 */
@Slf4j
@RestController
public class UserController {

    public static final String RESOURCE_NAME = "/query/{id}";

    /**
     * SentinelResource 改善接口中资源定义和被流控降级后的处理方法
     * 使用流程: 1.添加依赖<artifactId>sentinel-annotation-aspectj</artifactId>
     * 2.配置bean-SentinelResourceAspect
     * value:定义资源
     * blockHandler:设置降级后的处理方法(默认使用当前类的对应名称的方法,不必使用static修饰)
     * blockHandlerClass:如果将降级方法设置到当前类中，可以该注解指定某个类，将降级方法写到该类中(注意对应的函数必需为 static 函数，否则无法解析。)
     * -------------------------------------------------------------------------
     * 特别地，若 blockHandler 和 fallback 都进行了配置，则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑。
     * 若未配置 blockHandler、fallback 和 defaultFallback，则被限流降级时会将 BlockException 直接抛出
     * （若方法本身未定义 throws BlockException 则会被 JVM 包装一层 UndeclaredThrowableException）。
     */
    @GetMapping("/query/{id}")
//    @SentinelResource(
//            value = RESOURCE_NAME,
//            blockHandler = "queryByIdBlockHandleCurrentClass",
//            fallback = "queryByIdExceptionHandleCurrentClass"
//    )
    @SentinelResource(value = RESOURCE_NAME,
            blockHandlerClass = UserBlockHandler.class, blockHandler = "queryByIdBlockHandleOutSideClass",
            fallbackClass = UserExceptionHandler.class, fallback = "queryByIdExceptionHandleOutSideClass")
    public R<User> queryById(@PathVariable("id") Long id) {
        int i = 1 / 0;
        User user = User.builder().id(id).username("陈国红").build();
        return R.ok(user);
    }

    /**
     * 注意:
     * 1.一定要使用public
     * 2.返回值一定要和源方法保持一致，包含源方法的参顺和参数顺序
     * 3.可以在方法的最后添加BlockException，用于区分使用什么规则的处理方法
     */
//    public R<User> queryByIdBlockHandleCurrentClass(@PathVariable("id") Long id, BlockException e) {
//        User user = User.builder().id(id).username("被降级了,msg:" + e.getLocalizedMessage()).build();
//        return R.ok(user);
//    }
//
//    public R<User> queryByIdExceptionHandleCurrentClass(@PathVariable("id") Long id, Throwable e) {
//        User user = User.builder().id(id).username("发生异常了,msg:" + e.getLocalizedMessage()).build();
//        return R.ok(user);
//    }
    @PostConstruct
    public void initFLowRules() {
        List<FlowRule> rules = Lists.newArrayList();
        FlowRule rule = new FlowRule();
        rule.setResource(RESOURCE_NAME);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
