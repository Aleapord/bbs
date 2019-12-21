package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/")
    @ResponseBody
    public List<Post> postList(){
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    public String singlePost(){
        return "page-single-topic";
    }
    @PostMapping("/{postId}")
    @ResponseBody
    public Post getPost(@PathVariable("postId") int postId){

       return postService.getPost(postId);
    }


    @PostMapping("/addpost")
    @ResponseBody
    public HashMap<String,Object> addPost(Post post){
        HashMap<String,Object> hashMap = new HashMap<>();
        postService.addPost(post);
        hashMap.put("msg","插入成功");
        return hashMap;
    }
}
