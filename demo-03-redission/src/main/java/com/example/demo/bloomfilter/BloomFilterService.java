package com.example.demo.bloomfilter;

import org.redisson.api.RBloomFilter;
import org.springframework.stereotype.Service;

/**
 * 布隆过滤器服务
 */
@Service
public class BloomFilterService {

    private final RBloomFilter<String> bloomFilter;

    public BloomFilterService(RBloomFilter<String> bloomFilter) {
        this.bloomFilter = bloomFilter;
    }

    /**
     * 添加元素到布隆过滤器中
     * @param element 元素
     */
    public void add(String element) {
        bloomFilter.add(element);
    }

    /**
     * 判断元素是否在布隆过滤器中
     *
     * @param element 元素
     * @return 可能在 or 一定不在
     */
    public boolean maybeContains(String element) {
        return bloomFilter.contains(element);
    }

}
