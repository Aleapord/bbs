package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.LoginForm;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
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
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String admin() {
        return "admin_login";
    }

    @GetMapping("/center")
    public String adminCenter(){

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
    @ResponseBody
    public List<Post> getPosts() {
        return postService.getAllPost();
    }
    @PostMapping("/deletePost")
    @ResponseBody
    public HashMap<String,Object> deletePost(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.deletePost(postID);
        msg="删除成功";
        hashMap.put("msg",msg);
        return hashMap;
    }
    @GetMapping("/getUserList")
    @ResponseBody
    public List<User> getUser(){
        return userService.getAllUser();
    }
    @PostMapping("/deleteUser")
    @ResponseBody
    public HashMap<String,Object> deleteUser(int userID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        userService.deleteUser(userID);
        msg="删除成功";
        hashMap.put("msg",msg);
        return hashMap;
    }
    @PostMapping("/top")
    @ResponseBody
    public HashMap<String,Object> top(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.updateTop(1,postID);
        msg="置顶成功！";
        hashMap.put("msg",msg);
        return hashMap;

    }
    @PostMapping("/cancelTop")
    @ResponseBody
    public HashMap<String,Object> cancleTop(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.updateTop(0,postID);
        msg="取消置顶成功！";
        hashMap.put("msg",msg);
        return hashMap;
    }
    @PostMapping("/digest")
    @ResponseBody
    public HashMap<String,Object> digest(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.updatePoint(-1,postID);
        msg="加精成功！";
        hashMap.put("msg",msg);
        return hashMap;

    }
    @PostMapping("/cancelDigest")
    @ResponseBody
    public HashMap<String,Object> cancleDigest(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.updatePoint(0,postID);
        msg="取消加精成功！";
        hashMap.put("msg",msg);
        return hashMap;
    }
    @PostMapping("/updatePost")
    @ResponseBody
    public HashMap<String,Object> updatePost(Post post){
        HashMap<String,Object> hashMap = new HashMap<>();
        String msg = "";
        postService.updatePostbyPost(post);
        msg="取消加精成功！";
        hashMap.put("msg",msg);
        return hashMap;
    }

}
