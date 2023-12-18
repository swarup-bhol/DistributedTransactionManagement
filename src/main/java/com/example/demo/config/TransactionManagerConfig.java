package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class TransactionManagerConfig {

    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager (
            @Qualifier("mysqlPlatformTransactionManager")PlatformTransactionManager pgsqlTransactionManager,
            @Qualifier("pgsqlPlatformTransactionManager") PlatformTransactionManager pgsqlPlatformTransactionManager) {
        return new ChainedTransactionManager(pgsqlPlatformTransactionManager,
                pgsqlTransactionManager);
    }
}
