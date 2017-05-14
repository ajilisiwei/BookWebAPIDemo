package com.wei
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.tomcat.jdbc.pool.DataSource
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.MybatisProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager

/**
 * Created by WEI on 2017/5/13.
 */
@SpringBootApplication
@MapperScan('com.wei.dao')
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @Bean
    @ConfigurationProperties(prefix = 'spring.datasource')
    DataSource dataSource() {
        System.out.println("inited a datasource")
         new DataSource()
    }

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        def sqlSessionFactoryBean = new SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource())
        def resolve = resolver()
        def mybatisProperties = this.mybatisProperties()
        sqlSessionFactoryBean.setConfigLocation(resolve.getResource(mybatisProperties.getConfigLocation()))
        sqlSessionFactoryBean.setMapperLocations(resolve.getResources(mybatisProperties.mapperLocations[0]))
        sqlSessionFactoryBean.getObject()
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = 'mybatis')
    MybatisProperties mybatisProperties() {
        new MybatisProperties()
    }

    @Bean
    PathMatchingResourcePatternResolver resolver(){
        new PathMatchingResourcePatternResolver()
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        new DataSourceTransactionManager(dataSource())
    }

}
