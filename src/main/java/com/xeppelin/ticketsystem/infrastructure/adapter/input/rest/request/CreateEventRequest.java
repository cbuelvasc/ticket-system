package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.validation.ValidEventDates;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Request DTO for creating a new event.
 * <p>
 * This record demonstrates proper handling of ZonedDateTime fields
 * with timezone information preserved and validated.
 */
@ValidEventDates
@Schema(description = "Request to create a new event")
public record CreateEventRequest(

    @Schema(description = "Event name", example = "Spring Conference 2024", required = true, maxLength = 255)
    @NotBlank(message = "Event name is required")
    @Size(max = 255, message = "Event name cannot exceed 255 characters")
    String name,

    /**
     * Event start date and time with timezone.
     * Expected format: "2024-12-15T20:00:00+01:00[Europe/Madrid]"
     */
    @Schema(description = "Event start date and time with timezone",
        example = "2024-12-15T20:00:00+01:00[Europe/Madrid]",
        required = true, type = "string", format = "date-time")
    @NotNull(message = "Event start time is required")
    @Future(message = "Event must be scheduled for a future date")
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

    @Schema(description = "Event venue", example = "Madrid Convention Center", required = true, maxLength = 500)
    @NotBlank(message = "Venue is required")
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

    /**
     * List of staff member IDs assigned to this event.
     * Staff members must be existing users in the system.
     */
    @Schema(description = "List of staff member IDs assigned to this event",
        example = "[\"a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11\", \"b1ffcd99-9c0b-4ef8-bb6d-6bb9bd380a22\"]")
    List<UUID> staffIds,

    /**
     * List of ticket types for this event.
     * Optional - ticket types can be added later via separate endpoints.
     */
    @Schema(description = "List of ticket types for this event")
    @Valid
    List<CreateTicketTypeRequest> ticketTypes
) {
} 