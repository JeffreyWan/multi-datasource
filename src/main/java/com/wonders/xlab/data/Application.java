package com.wonders.xlab.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Jeffrey on 15/10/21.
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {

    @Autowired
    private JpaProperties jpaProperties;


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource dataSourcePrimary() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.secondary")
    public DataSource dataSourceSecondary() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        final DataSource dataSource = dataSourcePrimary();
        return builder.dataSource(dataSource)
                .packages("com.wonders.**.primary")
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
        final DataSource dataSource = dataSourceSecondary();
        return builder.dataSource(dataSource)
                .packages("com.wonders.**.secondary")
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .build();
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class);
    }
}
