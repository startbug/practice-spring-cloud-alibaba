package com.ggs.sentinelnew.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class HelloController {
//
//    public static final String RESOURCE_NAME = "hello";
//    public static final String DEGRADE_RESOURCE_NAME = "degrade";
//
//    @GetMapping(value = "/hello")
//    public String hello() {
//        Entry entry = null;
//
//        try {
//            // sentinel针对资源进行限制
//            entry = SphU.entry(RESOURCE_NAME);
//            // 被保护的业务逻辑
//            String str = "hello world~!";
//            log.info("-----------" + str + "--------------------");
//            return str;
//        } catch (BlockException e) {
//            // 资源访问阻止，被限流或降级
//            log.warn("block!!!!!!!");
//            return "被流控了，请稍后再试";
//        } catch (Exception e) {
//            // 若需要配置降级规则，则需要通过这种方式记录业务异常
//            Tracer.traceEntry(e, entry);
//        } finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Spring的初始化方法，和xml中的<bean init-method="initFlowRules"></bean>一样
//     */
//    @PostConstruct
//    private void initFlowRules() {
//        // 流控规则
//        List<FlowRule> rules = new ArrayList<>();
//
//        // 流控
//        FlowRule rule = new FlowRule();
//        // 设置受保护的资源
//        rule.setResource(RESOURCE_NAME);
//        // 设置使用的流控规则:QPS
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 设置受保护资源的阈值
//        // set limit QPS to 1
//        rule.setCount(1);
//        rules.add(rule);
//
//        FlowRuleManager.loadRules(rules);
//    }

}

