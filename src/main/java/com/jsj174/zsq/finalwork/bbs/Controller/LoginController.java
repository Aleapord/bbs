package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Exts.UserLoginToken;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
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
    @PostMapping("/login")
    @ResponseBody
    public Object login(User user) throws JSONException {
        HashMap<String,Object> jsonObject=new HashMap<>();
        User userForBase=userService.getUser(user.getUsername());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
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
