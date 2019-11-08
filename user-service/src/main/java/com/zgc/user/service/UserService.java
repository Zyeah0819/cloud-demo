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
    private UserMapper userMapper;

    public User queryUserById(Integer id){
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
