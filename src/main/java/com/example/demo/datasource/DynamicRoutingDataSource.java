package com.example.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 * @author xingang
 * @since 2024/6/20 14:11
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource implements ApplicationRunner {

    /**
     * 单例模式
     */
    private static final DynamicRoutingDataSource SINGLETON = new DynamicRoutingDataSource();

    private DynamicRoutingDataSource() {}

    public static DynamicRoutingDataSource getInstance() {
        return SINGLETON;
    }

    /**
     * AbstractRoutingDataSource的targetDataSources无法get到，自己维护一个
     */
    private static final Map<Object, Object> dataSourceMap = new HashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.get();
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(dataSourceMap);
    }

    /**
     * 添加数据源到动态数据源中
     * @param lookupKey          分布式ID用作lookupKey
     * @param dataSourceProperty 数据源属性
     */
    public void addDataSource(String lookupKey, DataSourceProperty dataSourceProperty) {
        dataSourceMap.put(lookupKey, DataSourceFactory.getDataSource(dataSourceProperty));
        resolveDataSources();
    }

    /**
     * 获取数据源
     * @param lookupKey 分布式ID用作lookupKey
     * @return 解析到的数据源
     */
    public DataSource getDataSource(String lookupKey) {
        return super.getResolvedDataSources().get(lookupKey);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 默认数据源
        DataSource defaultDataSource = new DruidDataSource();
        dataSourceMap.put("default", defaultDataSource);

        // 解析数据源到resolvedDataSources属性中
        resolveDataSources();
    }

    /**
     * 解析数据源到resolvedDataSources属性中
     */
    private void resolveDataSources() {
        setTargetDataSources(DynamicRoutingDataSource.dataSourceMap);
        afterPropertiesSet();
    }
}
