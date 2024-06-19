package com.example.demo.bloomfilter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BloomFilterServiceTest {

    @Autowired
    private BloomFilterService bloomFilterService;

    @Test
    public void test() {
        String element = "123";
        bloomFilterService.add(element);
        boolean maybeContains = bloomFilterService.maybeContains(element);
        System.out.println(maybeContains ? "Element might be present" : "Element is definitely not present");
    }
}
