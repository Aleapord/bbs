package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PostService postService;

    @GetMapping("/getposts")
    @ResponseBody
    public List<Post> getPosts(String userID){

        System.out.println(userID);
        return postService.getUserPost(Integer.parseInt(userID));
    }
    @GetMapping("/getuser")
    @ResponseBody
    public User getUser(int userID){
        return userService.getUser(userID);
    }
    @PostMapping("/update")
    @ResponseBody
    public HashMap<String,Object> updateUser(User user){
        HashMap<String,Object> hashMap = new HashMap<>();

        userService.updateUser(user);
        hashMap.put("msg","修改成功！");
        return hashMap;
    }
    @PostMapping("/deletePost")
    @ResponseBody
    public HashMap<String,Object> deletePost(int postID){
        HashMap<String,Object> hashMap = new HashMap<>();

        postService.deletePost(postID);
        hashMap.put("msg","修改成功！");
        return hashMap;
    }


    @PostMapping("/getWealth")
    @ResponseBody
    public HashMap<String, Object> getWealth(int userID) {
        HashMap<String, Object> hashMap = new HashMap<>();

        if (userService.getUser(userID) == null)
            hashMap.put("msg", "该用户不存在！");
        else {
            int wealth = userService.getWealth(userID);
            hashMap.put("wealth", wealth);
        }
        return hashMap;
    }
}
