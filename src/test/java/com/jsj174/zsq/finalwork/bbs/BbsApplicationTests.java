package com.jsj174.zsq.finalwork.bbs;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Services.CommentService;
import com.jsj174.zsq.finalwork.bbs.Services.PostService;
import com.jsj174.zsq.finalwork.bbs.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BbsApplicationTests {
    @Autowired
    RedisTemplate<Object,Object> template;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Test
    void contextLoads() {

    }

}
