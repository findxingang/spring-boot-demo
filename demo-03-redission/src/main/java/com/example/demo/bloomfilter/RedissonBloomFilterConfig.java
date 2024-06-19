package com.example.demo.bloomfilter;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 布隆过滤器配置类
 */
@Configuration
public class RedissonBloomFilterConfig {

    @Bean
    public RBloomFilter<String> bloomFilter(RedissonClient redissonClient) {
        // 布隆过滤器在Redis中的key是"bloomFilter"
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloomFilter");
        // 初始化布隆过滤器，预计插入1000,000个元素，误判率为0.01
        bloomFilter.tryInit(1000000, 0.01);
        return bloomFilter;
    }
}
