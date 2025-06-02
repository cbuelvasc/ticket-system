package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Simplified response DTO for Event information in list operations.
 * 
 * This record provides essential event data for list views
 * without the overhead of full related entities.
 */
@Schema(description = "Simplified event information for list operations")
public record EventSummaryResponse(
    
    @Schema(description = "Event unique identifier", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id,

    @Schema(description = "Event name", example = "Spring Conference 2024")
    String name,

    @Schema(description = "Event start date and time with timezone", 
            example = "2024-12-15T20:00:00+01:00[Europe/Madrid]",
            type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime start,

    @Schema(description = "Event end date and time with timezone", 
            example = "2024-12-15T23:00:00+01:00[Europe/Madrid]",
            type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime end,

    @Schema(description = "Event venue", example = "Madrid Convention Center")
    String venue,

    @Schema(description = "Event status", example = "PUBLISHED")
    EventStatusEnum status,

    @Schema(description = "Organizer name", example = "Tech Events Corp")
    String organizerName,

    @Schema(description = "Number of available ticket types", example = "3")
    Integer ticketTypesCount,

    @Schema(description = "Whether ticket sales are currently active", example = "true")
    Boolean salesActive
) {
} 