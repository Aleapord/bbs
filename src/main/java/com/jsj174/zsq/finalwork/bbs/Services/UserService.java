package com.jsj174.zsq.finalwork.bbs.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jsj174.zsq.finalwork.bbs.Mapper.UserMapper;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        return userMapper.getUserById(id);
    }
    public User getUser(String name){
        return userMapper.getUserByName(name);
    }
    public void deleteUser(User user){
        userMapper.deleteUser(user.getUserID());
    }

    public List<User> getAllUser() {

        return userMapper.getAllUser();
    }

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUserID()+"")
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
