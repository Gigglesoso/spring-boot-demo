package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置文件
 * 因为springboot默认不支持durid连接池，所以需要自己手动配置连接池相关的信息
 */
@Configuration
public class SpringDataConfig {

    //从配置文件中读取数据库连接的一些属性
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    /**
     * 配置数据库连接池
     */
    @Bean
    @Primary   //表明该连接池优先被使用
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcUrl);//设置连接地址
        dataSource.setUsername(username);//设置用户名密码
        dataSource.setPassword(password);//设置密码
        dataSource.setDriverClassName(driverClassName);//设置驱动名称
        
        dataSource.setInitialSize(initialSize);//初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
        dataSource.setMinIdle(minIdle);//连接池最小连接数
        dataSource.setMaxActive(maxActive);//连接池最大连接数量
        dataSource.setMaxWait(maxWait);//连接最大等待时间
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);//间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);//一个连接在池中最小生存的时间，单位是毫秒
        return dataSource;
    }
}
