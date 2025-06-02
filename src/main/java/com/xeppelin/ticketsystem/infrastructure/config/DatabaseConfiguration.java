package com.xeppelin.ticketsystem.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Configuration for JPA database operations.
 * <p>
 * This configuration sets up JPA repositories, entities, and auditing
 * for the PostgreSQL database.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "zonedDateTimeProvider")
@EntityScan("com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity")
@EnableJpaRepositories("com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository")
@EnableTransactionManagement(proxyTargetClass = true)
public class DatabaseConfiguration {
    
    @Bean
    public DateTimeProvider zonedDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}