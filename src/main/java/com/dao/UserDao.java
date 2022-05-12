package com.dao;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> select(){
        List<User> select = userMapper.select();
        return select;
    }
}
