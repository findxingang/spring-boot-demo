package com.example.lettuce;

import com.example.lettuce.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingang
 * @since 2024/05/29 18:13
 */
@SpringBootTest
@Slf4j
public class LettuceApplicationTests {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 打印 RedisTemplate Bean
     */
    @Test
    public void testRedisTemplateBean() {
        Map<String, RedisTemplate> beansOfType = applicationContext.getBeansOfType(RedisTemplate.class);
        for (Map.Entry<String, RedisTemplate> entry : beansOfType.entrySet()) {
            System.out.println(entry.getKey() + ": \t\t\t" + entry.getValue());
        }
    }

    /**
     * StringRedisTemplate 操作 String 类型
     */
    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("crhms:dev:xingang", "王新刚");
        String value = stringRedisTemplate.opsForValue().get("crhms:dev:xingang");
        log.info("value: {}", value);
    }

    /**
     * RedisTemplate 操作 Hash 类型
     */
    @Test
    public void testRedisTemplate() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "zhangsan");
        hashMap.put("age", 18);
        hashMap.put("birthdat", LocalDateTime.now());
        redisTemplate.opsForHash().putAll("crhms:dev:zhangsan", hashMap);
        Map<Object, Object> map = redisTemplate.opsForHash().entries("crhms:dev:zhangsan");
        map.forEach((k, v) -> {
            log.info("key: {}, value: {}", k, v);
        });
    }

    /**
     * RedisTemplate 序列化为 JSON
     */
    @Test
    public void testRedisTemplateJson() {
        User user = new User();
        user.setId("1");
        user.setName("xingang");
        user.setAge("18");
        user.setBirthday(LocalDateTime.now());

        // 情况1: 执行报错。
        // org.springframework.data.redis.serializer.SerializationException: Cannot serialize; nested exception is org.springframework.core.serializer.support.SerializationFailedException: Failed to serialize object using DefaultSerializer; nested exception is java.lang.IllegalArgumentException: DefaultSerializer requires a Serializable payload but received an object of type [com.example.lettuce.domain.User]
        // 情况2: 执行成功。序列化和反序列化没问题，但是Redis中查看不方便 \xAC\xED\x00\x05sr\x00\x1Fcom.example.lettuce.domain.User\x00\x00\x00\x00\x00\x00\x00\x01\x02\x00\x04L\x00\x03aget\x00\x12Ljava/lang/String;L\x00\x08birthdayt\x00\x19Ljava/time/LocalDateTime;L\x00\x02idq\x00~\x00\x01L\x00\x04nameq\x00~\x00\x01xpt\x00\x0218sr\x00\x0Djava.time.Ser\x95]\x84\xBA\x1B"H\xB2\x0C\x00\x00xpw\x0E\x05\x00\x00\x07\xE8\x05\x1E	0\x0A\x0DY\xF8\x00xt\x00\x011t\x00\x07xingang
        // 因为 User 类 implements Serializable
        // 情况3: 执行成功。Redis里边也适合人直接阅读
        // 因为 RedisConfig 中实现了新的 RedisTemplate，给 key 和 value 的指定了新的序列化方式
        redisTemplate.opsForValue().set("crhms:dev:xingang", user);
        User user1 = (User) redisTemplate.opsForValue().get("crhms:dev:xingang");
        log.info("user: {}", user1);
    }


    /**
     * RedisTemplate 默认的序列化：JDK
     */
    @Test
    public void testRedisTemplateJDK() {
        User user = new User();
        user.setId("1");
        user.setName("lisi");
        user.setAge("22");
        user.setBirthday(LocalDateTime.now());

        redisTemplate.opsForValue().set("crhms:dev:lisi", user);
        User user1 = (User) redisTemplate.opsForValue().get("crhms:dev:lisi");
        log.info("user: {}", user1);
    }


}
