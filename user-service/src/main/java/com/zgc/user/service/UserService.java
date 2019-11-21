package com.zgc.user.service;


import com.zgc.user.mapper.UserMapper;
import com.zgc.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
//    @Resource 会没有下划线提示，
    private UserMapper userMapper;//有下划线，但不影响使用,可以使用降低提示来消掉提示

    public User queryUserById(Integer id){
        //手动设执行超时
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @Transactional/*事务注解*/
    public void insert(User user){
        userMapper.insert(user);
    }
}
