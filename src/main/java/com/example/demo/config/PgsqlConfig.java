package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repository.pgsql",
        entityManagerFactoryRef = "pgsqlEntityManagerFactory", transactionManagerRef = "pgsqlPlatformTransactionManager")
public class PgsqlConfig {

    @Bean(name = "pgsqlDataSource")
    @ConfigurationProperties(prefix = "spring.pgsql.datasource")
    public DataSource pgsqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pgsqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pgsqlEntityManagerFactory(@Qualifier("pgsqlDataSource") DataSource pgsqlDataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(pgsqlDataSource);
        em.setPackagesToScan(new String[]{"com.example.demo.model.pgsql"});
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "pgsqlPlatformTransactionManager")
    public PlatformTransactionManager pgsqlPlatformTransactionManager(@Qualifier("pgsqlEntityManagerFactory") EntityManagerFactory pgsqlEntityManagerFactory) {
        return new JpaTransactionManager(pgsqlEntityManagerFactory);
    }
}
