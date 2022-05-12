package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.activation.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com")
@MapperScan(basePackages = "com.dao")
public class mybatisConfig {
    @Autowired
    private MybatisProperties mybatisProperties;
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(mybatisProperties.getDriver());
        dataSource.setUrl(mybatisProperties.getUrl());
        dataSource.setUsername(mybatisProperties.getUsername());
        dataSource.setPassword(mybatisProperties.getPassword());
        return (DataSource) dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource((javax.sql.DataSource) dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(mybatisProperties.getMapperLocations());
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
        return sqlSessionFactoryBean;
    }
}
