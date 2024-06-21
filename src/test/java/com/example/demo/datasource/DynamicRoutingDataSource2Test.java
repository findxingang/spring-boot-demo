package com.example.demo.datasource;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author xingang
 * @since 2024/6/20 17:39
 */
@SpringBootTest
class DynamicRoutingDataSource2Test {

    @Autowired
    private DynamicRoutingDataSource2 dynamicRoutingDataSource2;
    @Test
    void addDataSource() {
        // 组装数据
        long id = IdWorker.getId();
        String lookupKey = String.valueOf(id);
        DataSourceProperty dataSourceProperty = DataSourceProperty.builder().id(id).jdbcUrl("jdbc:mysql://localhost:3306").username("root").password("root").build();

        // 新增数据源
        dynamicRoutingDataSource2.addDataSource(lookupKey, dataSourceProperty);

        // 获取数据源连接
        DynamicDataSourceContextHolder.set(lookupKey);
        try (Connection connection = dynamicRoutingDataSource2.getConnection()) {
            SqlRunner sqlRunner = new SqlRunner(connection);
            List<Map<String, Object>> maps = sqlRunner.selectAll("show databases");
            maps.forEach(System.out::println);
        } catch (SQLException throwable) {
        }
    }
}