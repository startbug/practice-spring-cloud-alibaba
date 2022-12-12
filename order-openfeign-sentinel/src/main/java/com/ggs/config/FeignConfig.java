package com.ggs.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>全局配置：@Configuration注解，就全局生效</p>
 * <p>局部配置：针对某一个服务配置，不要添加@Configuration,在具体的Feign接口类中的@FeignClient注解中通过configuration属性指定</p>
 */
@Configuration
public class FeignConfig {

//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }

    /**
     * 超时时间配置
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 3000);
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignInterceptor();
    }

}
