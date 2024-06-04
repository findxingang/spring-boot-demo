package com.example.jedis;

import com.example.jedis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xingang
 * @since 2024/05/30 14:00
 */
@SpringBootTest
public class JedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("name", "xingang");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testRedisTemplateJson() {
        User user = new User();
        user.setId("1");
        user.setName("xingang");
        user.setAge("18");
        user.setBirthday(LocalDateTime.now());
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
