package com.ggs.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("xxx", "lskdjfklsd");
        template.uri("/100");
        log.info("feign拦截器");
    }

}
