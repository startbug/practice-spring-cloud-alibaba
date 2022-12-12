package com.ggs.sentinelnew.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.ggs.sentinelnew.common.R;
import com.ggs.sentinelnew.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/degrade")
public class DegradeController {

    public static final String DEGRADE_RESOURCE_NAME = "/degrade/test";

    @GetMapping("/test")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME,
            entryType = EntryType.IN,
            blockHandler = "blockHandlerForFb")
    public R<User> degrade(Long id) {
        int i = 1 / 0;
        return R.ok(null);
    }

    public R<User> blockHandlerForFb(Long id, BlockException e) {
        return R.ok(User.builder().id(id).username("降级了啊啊啊啊").build());
    }

    @PostConstruct
    public void initDegradeRule() {
        // 降级规则 异常
        List<DegradeRule> degradeRules = new ArrayList();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置降级策略:异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // count,minRequestAmount,statIntervalMs三个参数，表示再60秒内有两个请求发生了异常异常就出发熔断
        // 异常数： 2
        degradeRule.setCount(2);
        // 触发熔断最小请求数: 2
        degradeRule.setMinRequestAmount(2);
        // 统计时长: 单位:ms
        degradeRule.setStatIntervalMs(60 * 1000); // 时间太短不好测试
        // 熔断持续时长: 单位/秒
        // 一旦触发熔断，再次请求对应的接口就会直接降级
        // 10s过后---进入半开状态，回复接口的调用，但是如果第一次调用就异常，就会再次熔断，不会根据上面的配置的触发熔断
        degradeRule.setTimeWindow(10);
        degradeRules.add(degradeRule);

        DegradeRuleManager.loadRules(degradeRules);
    }

}
