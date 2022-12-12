package com.ggs.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ggs.order.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 针对业务方法进行流控
     */
    @Override
    @SentinelResource(value = "getUser")
    public String getUser() {
        System.out.println("获取用户信息");
        return "用户信息----";
    }

}
