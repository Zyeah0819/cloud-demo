package com.zgc.user.Controller;


import com.zgc.user.pojo.User;
import com.zgc.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller/*注意他和@restController的区别*/
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User  queryUserById(@PathVariable("id") Integer id){
        return userService.queryUserById(id);
    }

}
