package com.example.demo.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingang
 * @since 2024/6/20 17:35
 */
@Component
public class DynamicRoutingDataSource2 extends AbstractRoutingDataSource {

    /**
     * AbstractRoutingDataSource的targetDataSources无法get到，自己维护一个
     */
    private static final Map<Object, Object> dataSourceMap = new HashMap<>();

    public DynamicRoutingDataSource2() {
        this.setTargetDataSources(new HashMap<>());
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.get();
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
     * 解析数据源到resolvedDataSources属性中
     */
    private void resolveDataSources() {
        setTargetDataSources(DynamicRoutingDataSource2.dataSourceMap);
        afterPropertiesSet();
    }
}
