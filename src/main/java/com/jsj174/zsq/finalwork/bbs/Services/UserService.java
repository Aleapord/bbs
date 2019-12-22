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

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User getUser(int userID) {
        return userMapper.getUserById(userID);
    }

    public User getUser(String username) {
        return userMapper.getUserByName(username);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user.getUserID());
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public String getPassword(int userID) {
        return userMapper.getPassword(userID);
    }

    public String updatePassword(String password, String newPassword, String rePassword, int userID) {
        String oldPassword = getPassword(userID);
        if (!oldPassword.equals(password)) {
            return "原密码输入错误";
        } else if (newPassword.length() < 6 || newPassword.length() > 20) {
            return "新密码长度要在6~20之间";
        } else if (!newPassword.equals(rePassword)) {
            return "新密码两次输入不一致";
        }
        userMapper.updatePassword(newPassword, userID);
        return "ok";
    }

    public int getWealth(int userId) {
        return userMapper.getWealth(userId);
    }

    public void updateWealth(int wealth, int userID) {
        int oldWealth = getWealth(userID);
        userMapper.updateWealth(oldWealth + wealth, userID);
    }
}
