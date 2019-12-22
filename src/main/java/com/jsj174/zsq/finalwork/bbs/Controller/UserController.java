package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Models.User;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.TokenService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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


}
