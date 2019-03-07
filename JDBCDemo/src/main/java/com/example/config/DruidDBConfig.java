package com.example.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DruidDBConfig {
    private Logger logger= LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${datasource.url:#{null}}")
    private String ds1_dbUrl;
    @Value("${datasource.username: #{null}}")
    private String ds1_username;
    @Value("${datasource.password:#{null}}")
    private String ds1_password;
    @Value("${datasource.driverClassName:#{null}}")
    private String ds1_driverClassName;
    @Value("${datasource.initialSize:#{null}}")
    private Integer ds1_initialSize;
    @Value("${datasource.minIdle:#{null}}")
    private Integer ds1_minIdle;
    @Value("${datasource.maxActive:#{null}}")
    private Integer ds1_maxActive;
    @Value("${datasource.maxWait:#{null}}")
    private Integer ds1_maxWait;
    @Value("${datasource.timeBetweenEvictionRunsMillis:#{null}}")
    private Integer ds1_timeBetweenEvictionRunsMillis;
    @Value("${datasource.minEvictableIdleTimeMillis:#{null}}")
    private Integer ds1_minEvictableIdleTimeMillis;
    @Value("${datasource.validationQuery:#{null}}")
    private String ds1_validationQuery;
    @Value("${datasource.testWhileIdle:#{null}}")
    private Boolean ds1_testWhileIdle;
    @Value("${datasource.testOnBorrow:#{null}}")
    private Boolean ds1_testOnBorrow;
    @Value("${datasource.testOnReturn:#{null}}")
    private Boolean ds1_testOnReturn;
    @Value("${datasource.poolPreparedStatements:#{null}}")
    private Boolean ds1_poolPreparedStatements;
    @Value("${datasource.maxPoolPreparedStatementPerConnectionSize:#{null}}")
    private Integer ds1_maxPoolPreparedStatementPerConnectionSize;
    @Value("${datasource.filters:#{null}}")
    private String ds1_filters;
    @Value("{datasource.connectionProperties:#{null}}")
    private String ds1_connectionProperties;

    @Bean //声明其为bean实例
    @Primary//在同样的DataSource中,首先使用被标注的DataSource
    public DataSource dataouce(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.ds1_dbUrl);
        datasource.setUsername(ds1_username);
        datasource.setPassword(ds1_password);
        datasource.setDriverClassName(ds1_driverClassName);

        //configuration
        if(ds1_initialSize != null) {
            datasource.setInitialSize(ds1_initialSize);
        }
        if(ds1_minIdle != null) {
            datasource.setMinIdle(ds1_minIdle);
        }
        if(ds1_maxActive != null) {
            datasource.setMaxActive(ds1_maxActive);
        }
        if(ds1_maxWait != null) {
            datasource.setMaxWait(ds1_maxWait);
        }
        if(ds1_timeBetweenEvictionRunsMillis != null) {
            datasource.setTimeBetweenEvictionRunsMillis(ds1_timeBetweenEvictionRunsMillis);
        }
        if(ds1_minEvictableIdleTimeMillis != null) {
            datasource.setMinEvictableIdleTimeMillis(ds1_minEvictableIdleTimeMillis);
        }
        if(ds1_validationQuery!=null) {
            datasource.setValidationQuery(ds1_validationQuery);
        }
        if(ds1_testWhileIdle != null) {
            datasource.setTestWhileIdle(ds1_testWhileIdle);
        }
        if(ds1_testOnBorrow != null) {
            datasource.setTestOnBorrow(ds1_testOnBorrow);
        }
        if(ds1_testOnReturn != null) {
            datasource.setTestOnReturn(ds1_testOnReturn);
        }
        if(ds1_poolPreparedStatements != null) {
            datasource.setPoolPreparedStatements(ds1_poolPreparedStatements);
        }
        if(ds1_maxPoolPreparedStatementPerConnectionSize != null) {
            datasource.setMaxPoolPreparedStatementPerConnectionSize(ds1_maxPoolPreparedStatementPerConnectionSize);
        }

        if(ds1_connectionProperties != null) {
            datasource.setConnectionProperties(ds1_connectionProperties);
        }
        List<Filter> filters = new ArrayList<>();
        filters.add(statFilter());
        filters.add(wallFilter());
        datasource.setProxyFilters(filters);
        /*try {
            datasource.setFilters(ds1_filters);
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }*/
        return datasource;
    }

    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(1000);

        return statFilter;
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();

        //允许执行多条SQL  https://blog.csdn.net/blueheart20/article/details/52384032
        WallConfig config = new WallConfig();
        config.setMultiStatementAllow(true);
        wallFilter.setConfig(config);

        return wallFilter;
    }


}
