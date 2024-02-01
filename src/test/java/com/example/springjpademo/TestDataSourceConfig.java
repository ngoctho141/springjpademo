package com.example.springjpademo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@TestConfiguration
public class TestDataSourceConfig {

    @Bean
    public DataSource testDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Configure your test data source properties here
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("myuser");
        dataSource.setPassword("secret");
        return dataSource;
    }
}
