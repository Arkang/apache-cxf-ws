package org.arkang.soap.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.arkang.soap.demo.mapper.WelcomeMessageMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyBatisConfig {

    @Value("${spring.datasource.username}")
    private String databaseUser;
    @Value("${spring.datasource.usercode}")
    private String databasePasswd;
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePasswd);
        dataSource.setUrl(databaseUrl);
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(20);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(3600000);
        dataSource.setValidationQuery("SELECT 1");
        return dataSource;
    }

    @Bean
    @Primary
    public MapperFactoryBean<WelcomeMessageMapper> mapperFactoryBean() throws Exception {
        MapperFactoryBean<WelcomeMessageMapper> factoryBean = new MapperFactoryBean<>(WelcomeMessageMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(WelcomeMessageMapper.class);
        //sqlSessionFactory.getConfiguration().addMappers("org.arkang.soap.demo.mapper");
        return sqlSessionFactory;
    }

}
