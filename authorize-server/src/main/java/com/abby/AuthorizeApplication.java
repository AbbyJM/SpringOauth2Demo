package com.abby;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AuthorizeApplication {
    Logger logger= Logger.getLogger(AuthorizeApplication.class);
    public static void main(String[] args){
        SpringApplication.run(AuthorizeApplication.class);
    }

    public AuthorizeApplication(){

    }
}
