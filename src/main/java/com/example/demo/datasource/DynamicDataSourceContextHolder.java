package com.example.demo.datasource;

import org.springframework.stereotype.Component;

/**
 * @author xingang
 * @since 2024/6/20 14:46
 */
@Component
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> LOOKUP_KEY_HOLDER = new ThreadLocal<>();

    public static void set(String lookupKey) {
        LOOKUP_KEY_HOLDER.set(lookupKey);
    }

    public static String get() {
        return LOOKUP_KEY_HOLDER.get();
    }
}
