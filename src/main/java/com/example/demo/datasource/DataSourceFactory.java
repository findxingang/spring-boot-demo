package com.example.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author xingang
 * @since 2024/6/20 14:41
 */
@Component
public class DataSourceFactory {

    /**
     * 返回一个初始化好的数据源
     * @param dataSourceProperty 数据源配置
     */
    public static DataSource getDataSource(DataSourceProperty dataSourceProperty) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperty.getJdbcUrl());
        druidDataSource.setUsername(dataSourceProperty.getUsername());
        druidDataSource.setPassword(dataSourceProperty.getPassword());
        try {
            druidDataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException("初始化Druid数据源失败", e);
        }
        return druidDataSource;
    }
}
