package com.example.demo.datasource;

import lombok.Builder;
import lombok.Data;

/**
 * 数据源属性，在具体的项目中可以替换成自己的数据源属性
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
