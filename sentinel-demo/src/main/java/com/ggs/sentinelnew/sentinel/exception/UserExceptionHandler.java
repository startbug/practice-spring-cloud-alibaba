package com.ggs.sentinelnew.sentinel.exception;

import com.ggs.sentinelnew.common.R;
import com.ggs.sentinelnew.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

public class UserExceptionHandler {

    public static R<User> queryByIdExceptionHandleOutSideClass(@PathVariable("id") Long id, Throwable e) {
        User user = User.builder().id(id).username("外部处理--发生异常了,msg:" + e.getLocalizedMessage()).build();
        return R.ok(user);
    }

}
