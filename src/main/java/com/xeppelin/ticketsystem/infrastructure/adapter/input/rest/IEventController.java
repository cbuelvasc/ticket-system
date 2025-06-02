package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest;

import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.UpdateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventSummaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * REST API interface for Event management operations.
 * <p>
 * This interface defines the contract for Event REST endpoints following the API First approach
 * with comprehensive OpenAPI documentation. The interface separates the API contract and
 * documentation from the implementation logic.
 * </p>
 * <p>
 * The API handles two main scopes:
 * <ul>
 *   <li>Organizer operations: Full CRUD operations for events owned by specific organizers</li>
 *   <li>Public operations: Read-only access to published events for general consumers</li>
 * </ul>
 * </p>
 * <p>
 * Endpoint Structure:
 * <ul>
 *   <li>Base: /events</li>
 *   <li>Organizer operations: /events/organizers/{organizerId}/*</li>
 *   <li>Public operations: /events/*</li>
 * </ul>
 * </p>
 * <p>
 * Note: Ticket type management operations have been moved to a separate controller {@code ITicketTypeController}
 * following REST API best practices for resource separation.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Validated
@RequestMapping("/events")
@Tag(name = "Events", description = "Event management operations")
public interface IEventController {

    // =====================================================
    // ORGANIZER OPERATIONS
    // =====================================================

    @Operation(
        summary = "Create a new event",
        description = "Creates a new event for the specified organizer. The event will be created in DRAFT status by default.",
        operationId = "createEvent"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Event created successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = EventResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid request data or business rule violation",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Organizer not found",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "422",
            description = "Validation error",
            content = @Content(mediaType = "application/json")
        )
    })
    @PostMapping("/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.CREATED)
    EventResponse createEvent(
        @Parameter(
            description = "Organizer unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            in = ParameterIn.PATH
        )
        @PathVariable UUID organizerId,

        @Parameter(
            description = "Event creation request",
            required = true
        )
        @Valid @RequestBody CreateEventRequest request
    );

    @Operation(
        summary = "Get paginated events for organizer",
        description = "Retrieves a paginated list of events owned by the organizer",
        operationId = "listEventsForOrganizer"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Events retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Page.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Organizer not found",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    Page<EventSummaryResponse> listEventsForOrganizer(
        @Parameter(
            description = "Organizer unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            in = ParameterIn.PATH
        )
        @PathVariable UUID organizerId,

        @Parameter(description = "Pagination parameters")
        @PageableDefault(size = 10, sort = "start") Pageable pageable
    );

    @Operation(
        summary = "Get event details for organizer",
        description = "Retrieves detailed information about a specific event owned by the organizer",
        operationId = "getEventForOrganizer"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Event retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = EventResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not owned by organizer",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    EventResponse getEventForOrganizer(
        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId,
        @Parameter(
            description = "Organizer unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            in = ParameterIn.PATH
        )
        @PathVariable UUID organizerId
    );

    @Operation(
        summary = "Update event",
        description = "Updates an existing event owned by the organizer. Only provided fields will be updated.",
        operationId = "updateEventForOrganizer"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Event updated successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = EventResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid request data or business rule violation",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not owned by organizer",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "422",
            description = "Validation error or update not allowed",
            content = @Content(mediaType = "application/json")
        )
    })
    @PutMapping("/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    EventResponse updateEventForOrganizer(
        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId,

        @Parameter(
            description = "Organizer unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            in = ParameterIn.PATH
        )
        @PathVariable UUID organizerId,

        @Parameter(
            description = "Event update request",
            required = true
        )
        @Valid @RequestBody UpdateEventRequest request
    );

    @Operation(
        summary = "Delete event",
        description = "Deletes an event owned by the organizer. This operation is irreversible.",
        operationId = "deleteEventForOrganizer"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "Event deleted successfully"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not owned by organizer",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "422",
            description = "Deletion not allowed due to business rules",
            content = @Content(mediaType = "application/json")
        )
    })
    @DeleteMapping("/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEventForOrganizer(
        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId,

        @Parameter(
            description = "Organizer unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            in = ParameterIn.PATH
        )
        @PathVariable UUID organizerId
    );

    // =====================================================
    // PUBLIC OPERATIONS
    // =====================================================

    @Operation(
        summary = "Get published events",
        description = "Retrieves a paginated list of all published events available to the public",
        operationId = "listPublishedEvents"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Events retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Page.class)
            )
        )
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<EventSummaryResponse> listPublishedEvents(
        @Parameter(description = "Pagination parameters")
        @PageableDefault(size = 10, sort = "start") Pageable pageable
    );

    @Operation(
        summary = "Search events",
        description = "Searches for published events by name and venue using full-text search",
        operationId = "searchEvents"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Events found",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Page.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid search query",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    Page<EventSummaryResponse> searchEvents(
        @Parameter(
            description = "Search query for event name and venue",
            required = true,
            example = "spring conference"
        )
        @RequestParam String query,

        @Parameter(description = "Pagination parameters")
        @PageableDefault(size = 10, sort = "start") Pageable pageable
    );

    @Operation(
        summary = "Get public event details",
        description = "Retrieves detailed information about a specific published event",
        operationId = "getPublishedEvent"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Event retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = EventResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not published",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    EventResponse getPublishedEvent(
        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId
    );
} 