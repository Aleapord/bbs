package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Services.CommentService;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/getWealth")
    @ResponseBody
    public HashMap<String,Object> getWealth(@PathVariable int userID){
        HashMap<String,Object> hashMap = new HashMap<>();

        if(userService.getUser(userID) == null)
            hashMap.put("msg","该用户不存在！");
        else {
            int wealth = userService.getWealth(userID);
            hashMap.put("wealth",wealth);
        }
        return hashMap;
    }
}
