package com.xeppelin.ticketsystem.infrastructure.config;

import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Configuration for Redis cache functionality.
 * <p>
 * This configuration enables Redis for caching purposes only and explicitly
 * disables Redis repositories to prevent conflicts with JPA repositories.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableAutoConfiguration(exclude = RedisRepositoriesAutoConfiguration.class)
public class RedisConfiguration {
    
    // Redis configuration for caching is handled through application.yml
    // Redis repositories are disabled to prevent conflicts with JPA repositories
} 