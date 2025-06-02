package com.xeppelin.ticketsystem.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configuration for enabling scheduled tasks in the application.
 * 
 * This configuration enables Spring's scheduling capabilities
 * for running periodic tasks like cleaning up expired reservations.
 */
@Configuration
@EnableScheduling
public class SchedulingConfiguration {
    
    // Spring will automatically detect @Scheduled methods in beans
    // when @EnableScheduling is present
} 