package com.zgc.client;

import com.zgc.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserClientFallBack.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") long id);
}
