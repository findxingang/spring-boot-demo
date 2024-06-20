package com.example.demo.datasource;

import lombok.Builder;
import lombok.Data;

/**
 * @author xingang
 * @since 2024/6/20 14:17
 */
@Data
@Builder
public class DataSourceProperty {
    // 分布式ID作为lookupKey
    private Long id;
    private String jdbcUrl;
    private String username;
    private String password;
}
