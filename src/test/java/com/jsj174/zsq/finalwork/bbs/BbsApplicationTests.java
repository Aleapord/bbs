package com.jsj174.zsq.finalwork.bbs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BbsApplicationTests {
    @Autowired
    RedisTemplate<Object,Object> template;



    @Test
    void contextLoads() {
        System.out.println(template.opsForValue().get("password"));


    }

}
