package com.jsj174.zsq.finalwork.bbs.Controller;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import com.jsj174.zsq.finalwork.bbs.Services.CommentService;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseBody
    public List<Post> postList() {
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    @ResponseBody
    public Post getPost(@PathVariable("postId") int postId) {

        return postService.getPost(postId);
    }

    @GetMapping("/like/{postID}")
    @ResponseBody
    public HashMap<String, Object> like(@PathVariable int postID) {
        HashMap<String, Object> hashMap = new HashMap<>();
        postService.updateLikes(postID);
        Post post = postService.getPost(postID);
        hashMap.put("likes", post.getLikes());
        return hashMap;
    }


    @GetMapping("/getComments/{postID}")
    @ResponseBody
    public List<Comment> getComments(@PathVariable int postID) {
        return commentService.getComments(postID);
    }

    @PostMapping("/addpost")
    @ResponseBody
    public HashMap<String, Object> addPost(Post post) {
        HashMap<String, Object> hashMap = new HashMap<>();
        postService.addPost(post);
        if (post.getPoint() != 0) {
            userService.updateWealth((-post.getPoint()), post.getUserID());      // 减去用户的财富
        } else {
            userService.updateWealth(10, post.getUserID());      // 更新用户的财富
        }
        hashMap.put("msg", "插入成功");
        return hashMap;
    }

    @PostMapping("/addComment")
    @ResponseBody
    public HashMap<String, Object> addComment(Comment comment) {
        HashMap<String, Object> hashMap = new HashMap<>();
        commentService.addComment(comment);     // 加评论
        postService.updateReplies(comment.getPostID());     // 加回复数
        userService.updateWealth(5, comment.getUserID());      // 更新用户的财富
        hashMap.put("msg", "插入成功");
        return hashMap;
    }

    @GetMapping("/addView/{postID}")
    @ResponseBody
    public HashMap<String, Object> addView(@PathVariable int postID) {
        HashMap<String, Object> hashMap = new HashMap<>();
        postService.updateViews(postID);
        hashMap.put("msg", "阅读数加1");
        return hashMap;
    }

    @PostMapping("/setAnswer")
    @ResponseBody
    public HashMap<String, Object> setAnswer(int commentID,int point,int postID, int userID) {
        System.out.println(postID + ":" + commentID);

        commentService.updateAnswer(commentID);
        postService.updatePoint(1,postID);

        userService.updateWealth(point,userID);
        return new HashMap<>();
    }
}
