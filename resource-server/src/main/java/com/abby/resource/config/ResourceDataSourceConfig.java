package com.abby.resource.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ResourceDataSourceConfig {
    @Bean
    public DataSource resourceDataSource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/test?autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
}
