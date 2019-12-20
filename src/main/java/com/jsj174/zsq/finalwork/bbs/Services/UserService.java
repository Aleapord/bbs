package com.jsj174.zsq.finalwork.bbs.Services;

import com.jsj174.zsq.finalwork.bbs.Mapper.UserMapper;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    public User getUser(int id){
        return userMapper.getUserById(id);
    }
    public User getUser(String name){
        return userMapper.getUserByName(name);
    }
    public List<User> getAllUser() {

        return userMapper.getAllUser();
    }
    public void deleteUser(User user){
        userMapper.deleteUser(user.getUserID());
    }

    public List<User> getAllUser() {

        return userMapper.getAllUser();
    }

}
