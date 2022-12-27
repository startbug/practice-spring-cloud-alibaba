package com.ggs.seatastock.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private String code;

    private String message;

    private Object data;

    public static CommonResponse ok(Object data) {
        return new CommonResponse("200", "操作成功 ", data);
    }

    public static CommonResponse fail(String message) {
        return new CommonResponse("200", message, null);
    }

    public static CommonResponse fail(String code, String message) {
        return new CommonResponse(code, message, null);
    }

}
