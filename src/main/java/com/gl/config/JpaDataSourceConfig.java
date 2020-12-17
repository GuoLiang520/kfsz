package com.gl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 郭亮
 * @date 2020/9/25 14:51 
 **/
@EnableJpaRepositories(basePackages = "com.gl.dao",
    entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
    transactionManagerRef = "jpaPlatformTransactionManager")
@Configuration
public class JpaDataSourceConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        Map propertis = new HashMap();
        propertis.put("show-sql","true");
        return entityManagerFactoryBuilder.dataSource(dataSource).persistenceUnit("pu1").packages("com.gl.entity").properties(propertis).build();
    }

    @Bean
    public PlatformTransactionManager jpaPlatformTransactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
