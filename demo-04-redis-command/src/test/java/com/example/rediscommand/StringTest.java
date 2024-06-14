package com.example.rediscommand;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author xingang
 * @since 2024/06/04 10:02
 */
@SpringBootTest
public class StringTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * set 和 get
     */
    @Test
    public void setAndGet() {
        // set 和 get
        redisTemplate.opsForValue().set("test", "test");
        String test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }
}
