package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

/**
 * Request DTO for creating a temporary ticket reservation.
 * 
 * This DTO allows users to request a temporary hold on tickets
 * while they complete the purchase process.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {

    @NotNull(message = "Event ID is required")
    private UUID eventId;

    @NotNull(message = "Ticket type ID is required")
    private UUID ticketTypeId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 10, message = "Maximum 10 tickets per reservation")
    private Integer quantity;
    
    @Min(value = 5, message = "Minimum reservation duration is 5 minutes")
    @Max(value = 60, message = "Maximum reservation duration is 60 minutes")
    private Integer durationMinutes;
    
    public Duration getReservationDuration() {
        return durationMinutes != null ? 
            Duration.ofMinutes(durationMinutes) : 
            Duration.ofMinutes(15); // Default 15 minutes
    }
} 