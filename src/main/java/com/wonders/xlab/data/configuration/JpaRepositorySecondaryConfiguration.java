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
        basePackages = "com.wonders.**.repository.secondary",
        entityManagerFactoryRef = "entityManagerFactorySecondary",
        transactionManagerRef = "secondaryTransactionManager"
)
public class JpaRepositorySecondaryConfiguration {

    @Autowired
    @Qualifier("entityManagerFactorySecondary")
    private EntityManagerFactory entityManagerFactorySecondary;

    @Bean
    public PlatformTransactionManager secondaryTransactionManager() {
        return new JpaTransactionManager(entityManagerFactorySecondary);
    }
}
