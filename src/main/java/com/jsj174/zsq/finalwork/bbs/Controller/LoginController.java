package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Exts.UserLoginToken;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.geometry.Pos;
import org.json.JSONException;
import org.json.JSONObject;
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


    @Autowired
    private TokenService tokenService;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "page-login";
    }
    @GetMapping("/sign-up")
    public String signUp(){

        return "page-signup";
    }
    @PostMapping("/sign-up")
    @ResponseBody
    public HashMap<String,Object> signUp(User user){
        User user1=null;
        HashMap<String,Object> hashMap=new HashMap<>();
        String msg="";
        user1 = userService.getUser(user.getUsername());
        if(user1==null){
            userService.insertUser(user);
            msg="注册成功！";
            hashMap.put("status",1);
        }else {
            msg="用户已存在！";
            hashMap.put("status",-1);
        }
        User user2=userService.getUser(user.getUsername());
     hashMap.put("msg",msg);
     hashMap.put("user",user2);
        return hashMap;
    }


    @PostMapping("/login")
    @ResponseBody
    public Object login(User user){
        HashMap<String,Object> hashMap=new HashMap<>();
        User userForBase=userService.getUser(user.getUsername());
        if(userForBase==null){
            hashMap.put("message","登录失败,用户不存在");
            return hashMap;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                hashMap.put("message","登录失败,密码错误");
                return hashMap;
            }else {
                String token = tokenService.getToken(userForBase);
                hashMap.put("message",1);
                hashMap.put("token", token);
                hashMap.put("user", userForBase);
                return hashMap;
            }
        }
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Post> get(){

        System.out.println(postService.getAllPost());

        return postService.getAllPost();
    }

}
