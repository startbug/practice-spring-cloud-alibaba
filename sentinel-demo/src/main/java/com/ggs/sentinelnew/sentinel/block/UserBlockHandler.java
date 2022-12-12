package com.ggs.sentinelnew.sentinel.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.sentinelnew.common.R;
import com.ggs.sentinelnew.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

public class UserBlockHandler {

    public static R<User> queryByIdBlockHandleOutSideClass(@PathVariable("id") Long id, BlockException e) {
        User user = User.builder().id(id).username("外部处理--被降级了,msg:" + e.getLocalizedMessage()).build();
        return R.ok(user);
    }

}
