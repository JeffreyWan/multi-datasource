package com.wonders.xlab.data.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Jeffrey on 15/10/21.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.wonders.**.repository.primary",
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "primaryTransactionManager"
)
public class JpaRepositoryPrimaryConfiguration {

    @Autowired
    @Qualifier("entityManagerFactoryPrimary")
    private EntityManagerFactory entityManagerFactoryPrimary;

    @Bean
    public PlatformTransactionManager primaryTransactionManager() {
        return new JpaTransactionManager(entityManagerFactoryPrimary);
    }
}
