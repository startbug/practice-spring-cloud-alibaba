package com.ggs.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(value = {SocketTimeoutException.class})
    public String socketTimeoutExceptionHandler(Exception e) throws JsonProcessingException {
        System.out.println(e.getMessage());
        Map hashMap = new HashMap();
        hashMap.put("msg", e.getLocalizedMessage());
        hashMap.put("xxxx", 123123);
        return objectMapper.writeValueAsString(hashMap);
    }

}
