package com.zgc.client;

import com.zgc.pojo.User;
import org.springframework.stereotype.Component;

@Component //注入到Spring中
public class UserClientFallBack implements UserClient {
    //每写一个方法，就要有一个fallback方法对应，麻烦
    @Override
    public User queryById(long id) {
        User user = new User();

        user.setName("用户查询出现异常！");
        return user;

    }
}
