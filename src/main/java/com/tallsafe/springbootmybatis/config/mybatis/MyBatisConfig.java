package com.tallsafe.springbootmybatis.config.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MyBatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    @ConditionalOnMissingBean //当容器里没有指定的Bean的情况下创建该对象
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            // 设置数据源
            sqlSessionFactoryBean.setDataSource(dataSource);
            // 设置mybatis的主配置文件
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
            sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);

            //设置mybatis扫描的mapper.xml文件的路径（非常重要，否则找不到mapper.xml文件）
            Resource[] mapperResources = resolver.getResources("classpath:mappers/*.xml");
            sqlSessionFactoryBean.setMapperLocations(mapperResources);
            // 设置别名包，便于在mapper.xml文件中ParemeType和resultType不要写完整的包

            sqlSessionFactoryBean.setTypeAliasesPackage("com.tallsafe.springbootmybatis.model");
            return sqlSessionFactoryBean.getObject();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw  new RuntimeException();
        }

    }

}
