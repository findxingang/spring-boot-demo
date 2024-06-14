package com.example.rediscommand;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author xingang
 * @since 2024/06/04 14:24
 */
@SpringBootTest
public class KeysTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 删除key
     */
    @Test
    public void del() {
        // 新增一个key，可以正常获取value
        redisTemplate.opsForValue().set("key", "value");
        Object value = redisTemplate.opsForValue().get("key");
        System.out.println("value：" + value);

        // 删除key后，获取value为null
        Boolean isSuccess = redisTemplate.delete("key");
        System.out.println("删除是否成功：" + isSuccess);
        Object object = redisTemplate.opsForValue().get("key");
        System.out.println("value：" + object);

        Boolean deleted = redisTemplate.delete("key");
        System.out.println("删除一个不存在的key：" + deleted);
        /*
         * value：value
         * 删除是否成功：true
         * value：null
         * 删除一个不存在的key：false
         */
    }


    @Test
    public void dump() {

    }
}
