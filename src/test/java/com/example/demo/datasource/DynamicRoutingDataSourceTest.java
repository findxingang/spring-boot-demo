package com.example.demo.datasource;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author xingang
 * @since 2024/6/20 14:52
 */
public class DynamicRoutingDataSourceTest {
    @Test
    void addDataSource() {

        long id = IdWorker.getId();
        String lookupKey = String.valueOf(id);
        DataSourceProperty dataSourceProperty = DataSourceProperty.builder().id(id).jdbcUrl("jdbc:mysql://localhost:3306").username("root").password("root").build();
        DynamicRoutingDataSource.getInstance().addDataSource(lookupKey, dataSourceProperty);

        DynamicDataSourceContextHolder.set(lookupKey);
        try (Connection connection = DynamicRoutingDataSource.getInstance().getConnection()) {
            SqlRunner sqlRunner = new SqlRunner(connection);
            List<Map<String, Object>> maps = sqlRunner.selectAll("show databases");
            System.out.println(maps);
        } catch (SQLException throwable) {
        }
    }

    @Test
    void getDataSource() {
        String lookupKey = "datasource1";
        DataSourceProperty dataSourceProperty = DataSourceProperty.builder().jdbcUrl("jdbc:mysql://localhost:3306").username("root").password("root").build();
        DynamicRoutingDataSource.getInstance().addDataSource(lookupKey, dataSourceProperty);
        DataSource dataSource = DynamicRoutingDataSource.getInstance().getDataSource(lookupKey);
        System.out.println(dataSource);
        System.out.println("\n\n");
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("show databases;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(0));
            }
        } catch (SQLException e) {
        }
    }

    private String testStr() {
        return String.format("Hello,%s", "world");
    }

    @Test
    void test() {

    }
}
