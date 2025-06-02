package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response DTO for Event information.
 * <p>
 * This record provides a clean representation of event data
 * with proper timezone handling and comprehensive documentation.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Schema(description = "Event information response")
public record EventResponse(

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

    @Schema(description = "Ticket sales start date and time with timezone",
        example = "2024-11-01T10:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime salesStart,

    @Schema(description = "Ticket sales end date and time with timezone",
        example = "2024-12-15T19:00:00+01:00[Europe/Madrid]",
        type = "string", format = "date-time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'")
    ZonedDateTime salesEnd,

    @Schema(description = "Event status", example = "PUBLISHED")
    EventStatusEnum status,

    @Schema(description = "Event organizer information")
    UserResponse organizer,

    @Schema(description = "List of event attendees")
    List<UserResponse> attendees,

    @Schema(description = "List of event staff")
    List<UserResponse> staff,

    @Schema(description = "List of available ticket types")
    List<EventTicketTypeResponse> ticketTypes
) {
} 