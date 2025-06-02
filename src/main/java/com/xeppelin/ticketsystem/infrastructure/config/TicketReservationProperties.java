package com.xeppelin.ticketsystem.infrastructure.config;

import java.time.Duration;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for ticket reservation management.
 * <p>
 * This class centralizes all ticket reservation-related constants and makes them
 * configurable through external properties files. It follows Spring Boot best practices
 * for type-safe configuration properties.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Data
@Component
@Validated
@ConfigurationProperties(prefix = "app.ticket.reservation")
public class TicketReservationProperties {

    @NotNull
    @Min(value = 1, message = "Maximum reservations per session must be at least 1")
    private Integer maxReservationsPerSession = 5;

    @NotNull
    @Min(value = 1, message = "Maximum quantity per reservation must be at least 1")
    private Integer maxQuantityPerReservation = 10;

    @NotNull
    private Duration maxExtensionDuration = Duration.ofHours(1);

    @NotNull
    private Duration defaultReservationDuration = Duration.ofMinutes(15);

    @NotNull
    private Duration expirationGracePeriod = Duration.ofMinutes(1);
} 