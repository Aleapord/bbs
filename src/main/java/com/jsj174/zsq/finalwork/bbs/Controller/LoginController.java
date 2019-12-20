package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.LoginForm;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;



    @GetMapping("/")
    public String home(){
        return "index";
    }
    @PostMapping("login/")
    @ResponseBody
    public List<User> login(){
        List<User> users=null;
        if (redisTemplate.opsForValue().get("users")==null){
            users = userService.getAllUser();
            System.out.println(users);
            redisTemplate.opsForValue().set("users",users);
        }else {
            users=(List<User>) redisTemplate.opsForValue().get("users");

        }

        return users;
    }

}
