package com.xeppelin.ticketsystem.infrastructure.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Unit tests for {@link TicketReservationProperties}.
 * <p>
 * Tests verify that configuration properties are correctly loaded and validated
 * from application properties files.
 * </p>
 */
@SpringBootTest
@TestPropertySource(properties = {
    "app.ticket.reservation.max-reservations-per-session=3",
    "app.ticket.reservation.max-quantity-per-reservation=5",
    "app.ticket.reservation.max-extension-duration=PT30M",
    "app.ticket.reservation.default-reservation-duration=PT10M",
    "app.ticket.reservation.expiration-grace-period=PT30S"
})
@DisplayName("TicketReservationProperties Tests")
class TicketReservationPropertiesTest {

    @Autowired
    private TicketReservationProperties properties;

    @Test
    @DisplayName("Should load max reservations per session from properties")
    void shouldLoadMaxReservationsPerSession() {
        assertThat(properties.getMaxReservationsPerSession()).isEqualTo(3);
    }

    @Test
    @DisplayName("Should load max quantity per reservation from properties")
    void shouldLoadMaxQuantityPerReservation() {
        assertThat(properties.getMaxQuantityPerReservation()).isEqualTo(5);
    }

    @Test
    @DisplayName("Should load max extension duration from properties")
    void shouldLoadMaxExtensionDuration() {
        assertThat(properties.getMaxExtensionDuration()).isEqualTo(Duration.ofMinutes(30));
    }

    @Test
    @DisplayName("Should load default reservation duration from properties")
    void shouldLoadDefaultReservationDuration() {
        assertThat(properties.getDefaultReservationDuration()).isEqualTo(Duration.ofMinutes(10));
    }

    @Test
    @DisplayName("Should load expiration grace period from properties")
    void shouldLoadExpirationGracePeriod() {
        assertThat(properties.getExpirationGracePeriod()).isEqualTo(Duration.ofSeconds(30));
    }
} 