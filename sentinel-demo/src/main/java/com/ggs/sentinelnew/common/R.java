package com.ggs.sentinelnew.common;

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

    private String code;

    private T data;

    public static <T> R ok(T data) {
        return new R<T>("成功", "A10000", data);
    }

    public static <T> R fail(String msg) {
        return new R<T>(StringUtils.isEmpty(msg)? "失败":msg, "B10000", null);
    }

}

