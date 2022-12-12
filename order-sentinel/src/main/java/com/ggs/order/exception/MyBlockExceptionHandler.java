package com.ggs.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.order.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        log.info("BlockExceptionHandler BlockException================" + e.getRule());

        R r = null;

        if (e instanceof FlowException) {
            r =     R.error(100, "接口限流了1111111111");

        } else if (e instanceof DegradeException) {
            r = R.error(101, "服务降级了");

        } else if (e instanceof ParamFlowException) {
            r = R.error(102, "热点参数限流了");

        } else if (e instanceof SystemBlockException) {
            r = R.error(103, "触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
            r = R.error(104, "授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), r);
    }

}
