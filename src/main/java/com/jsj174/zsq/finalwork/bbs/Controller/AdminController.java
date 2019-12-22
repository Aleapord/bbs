package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.LoginForm;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PostService postService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/")
    public String admin() {
        return "admin";
    }
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(LoginForm loginForm){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        String token="";
        System.out.println(loginForm.getName()+loginForm.getPassword());
        int status=0;
        if(loginForm.getName().equals("Admin")){
            if (loginForm.getPassword().equals("123456")){
                msg="登录成功！";
                status=1;
                hashMap.put("token",tokenService.getToken(loginForm.getName(),loginForm.getPassword()));
            }else {
                msg = "密码错误！";
                status = 0;
            }
        }
        else {
            msg="请输入正确的用户名！";
            status=0;
        }
        hashMap.put("msg",msg);
        hashMap.put("status",status);

        return hashMap;

    }

    @GetMapping("/getpostlist")
    public List<Post> getPosts() {
        return postService.getAllPost();
    }

}
