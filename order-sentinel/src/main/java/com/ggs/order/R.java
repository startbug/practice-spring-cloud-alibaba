package com.ggs.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> implements Serializable {

    private String msg;

    private int code;

    private T data;

    public static <T> R ok(T data) {
        return new R<T>("成功", 10000, data);
    }

    public static <T> R fail(String msg) {
        return new R<T>(StringUtils.isEmpty(msg) ? "失败" : msg, 20000, null);
    }

    public static R error(int code, String msg) {
        return new R(msg, code, null);
    }

}

