package com.abby.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class TokenConfig {

    @Autowired
    @Qualifier("resourceDataSource")
    private DataSource dataSource;

    @Bean
    public TokenStore jdbcTokenStore() throws Exception {
        if(dataSource==null){
            throw new Exception("data source is null");
        }
        return new JdbcTokenStore(dataSource);
    }

}
