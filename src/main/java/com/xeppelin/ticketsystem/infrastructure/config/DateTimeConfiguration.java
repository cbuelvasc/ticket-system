package com.xeppelin.ticketsystem.infrastructure.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Configuration for date and time handling across the application.
 * 
 * This configuration ensures consistent handling of ZonedDateTime objects
 * throughout the application, including proper serialization/deserialization
 * in JSON responses and database persistence.
 */
@Configuration
public class DateTimeConfiguration {

    /**
     * Standard ISO 8601 format with timezone information.
     * Example: "2024-12-15T20:00:00+01:00[Europe/Madrid]"
     */
    public static final DateTimeFormatter ZONED_DATETIME_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'");

    /**
     * Application default timezone - UTC for consistency.
     * All timestamps are stored in UTC and converted to user's timezone in presentation layer.
     */
    public static final ZoneId APPLICATION_DEFAULT_ZONE = ZoneId.of("UTC");

    /**
     * Configure JavaTimeModule for proper ZonedDateTime serialization.
     * This ensures that ZonedDateTime objects are properly serialized to ISO format
     * with timezone information preserved.
     */
    @Bean
    @Primary
    public JavaTimeModule javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        
        // Configure ZonedDateTime serializer to include timezone information
        module.addSerializer(java.time.ZonedDateTime.class, 
            new ZonedDateTimeSerializer(ZONED_DATETIME_FORMATTER));
        
        return module;
    }
} 