package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.validation.ValidEventDates;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import java.time.ZonedDateTime;

/**
 * Request DTO for updating an existing event.
 * <p>
 * This record demonstrates proper handling of ZonedDateTime fields
 * with timezone information preserved and validated for update operations.
 */
@ValidEventDates
@Schema(description = "Request to update an existing event")
public record UpdateEventRequest(

    @Schema(description = "Event name", example = "Spring Conference 2024", maxLength = 255)
    @Size(max = 255, message = "Event name cannot exceed 255 characters")
    String name,

    /**
     * Event start date and time with timezone.
     * Expected format: "2024-12-15T20:00:00+01:00[Europe/Madrid]"
     */
    @Schema(description = "Event start date and time with timezone",
        example = "2024-12-15T20:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime start,

    /**
     * Event end date and time with timezone.
     * Expected format: "2024-12-15T23:00:00+01:00[Europe/Madrid]"
     */
    @Schema(description = "Event end date and time with timezone",
        example = "2024-12-15T23:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime end,

    @Schema(description = "Event venue", example = "Madrid Convention Center", maxLength = 500)
    @Size(max = 500, message = "Venue cannot exceed 500 characters")
    String venue,

    /**
     * Ticket sales start date and time with timezone.
     * If not provided, sales start immediately.
     */
    @Schema(description = "Ticket sales start date and time with timezone",
        example = "2024-11-01T10:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime salesStart,

    /**
     * Ticket sales end date and time with timezone.
     * If not provided, sales continue until event start.
     */
    @Schema(description = "Ticket sales end date and time with timezone",
        example = "2024-12-15T19:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime salesEnd,

    @Schema(description = "Event status", example = "PUBLISHED")
    EventStatusEnum status
) {
} 