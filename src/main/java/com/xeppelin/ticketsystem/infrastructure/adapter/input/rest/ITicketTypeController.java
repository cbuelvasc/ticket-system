package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest;

import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateTicketTypeRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.UpdateTicketTypeRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.TicketTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * REST API interface for Ticket Type management operations.
 * <p>
 * This interface defines the contract for Ticket Type REST endpoints following the API First approach
 * with comprehensive OpenAPI documentation. The interface separates the API contract and
 * documentation from the implementation logic.
 * </p>
 * <p>
 * The API handles ticket type management for events including:
 * <ul>
 *   <li>Creating new ticket types for events</li>
 *   <li>Retrieving ticket types associated with events</li>
 *   <li>Updating existing ticket types</li>
 *   <li>Deleting ticket types (when business rules allow)</li>
 * </ul>
 * </p>
 * <p>
 * Endpoint Structure:
 * <ul>
 *   <li>Base: /ticket-types</li>
 *   <li>Event-specific operations: /ticket-types/events/{eventId}/organizers/{organizerId}/*</li>
 *   <li>Public operations: /ticket-types/events/{eventId}/public/*</li>
 * </ul>
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Validated
@RequestMapping("/ticket-types")
@Tag(name = "Ticket Types", description = "Ticket type management operations")
public interface ITicketTypeController {

    // =====================================================
    // ORGANIZER OPERATIONS
    // =====================================================

    @Operation(
        summary = "Create ticket type for event",
        description = "Creates a new ticket type for the specified event. The organizer must own the event.",
        operationId = "createTicketType"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Ticket type created successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
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
            description = "Validation error",
            content = @Content(mediaType = "application/json")
        )
    })
    @PostMapping("/events/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.CREATED)
    TicketTypeResponse createTicketType(
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
            description = "Ticket type creation request",
            required = true
        )
        @Valid @RequestBody CreateTicketTypeRequest request
    );

    @Operation(
        summary = "Get ticket types for event",
        description = "Retrieves all ticket types for the specified event owned by the organizer",
        operationId = "getTicketTypesForEvent"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Ticket types retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not owned by organizer",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/events/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    List<TicketTypeResponse> getTicketTypesForEvent(
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
        summary = "Get specific ticket type details",
        description = "Retrieves detailed information about a specific ticket type for an event owned by the organizer",
        operationId = "getTicketTypeForEvent"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Ticket type retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ticket type or event not found, or not owned by organizer",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/{ticketTypeId}/events/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    TicketTypeResponse getTicketTypeForEvent(
        @Parameter(
            description = "Ticket type unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174002",
            in = ParameterIn.PATH
        )
        @PathVariable UUID ticketTypeId,

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
        summary = "Update ticket type",
        description = "Updates an existing ticket type for the event. Only provided fields will be updated.",
        operationId = "updateTicketType"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Ticket type updated successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid request data or business rule violation",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ticket type or event not found, or not owned by organizer",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "422",
            description = "Validation error or update not allowed",
            content = @Content(mediaType = "application/json")
        )
    })
    @PutMapping("/{ticketTypeId}/events/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.OK)
    TicketTypeResponse updateTicketType(
        @Parameter(
            description = "Ticket type unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174002",
            in = ParameterIn.PATH
        )
        @PathVariable UUID ticketTypeId,

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
            description = "Ticket type update request",
            required = true
        )
        @Valid @RequestBody UpdateTicketTypeRequest request
    );

    @Operation(
        summary = "Delete ticket type",
        description = "Deletes a ticket type from the event. Cannot delete if there are associated tickets.",
        operationId = "deleteTicketType"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "Ticket type deleted successfully"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ticket type or event not found, or not owned by organizer",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "422",
            description = "Deletion not allowed due to business rules (e.g., tickets already sold)",
            content = @Content(mediaType = "application/json")
        )
    })
    @DeleteMapping("/{ticketTypeId}/events/{eventId}/organizers/{organizerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicketType(
        @Parameter(
            description = "Ticket type unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174002",
            in = ParameterIn.PATH
        )
        @PathVariable UUID ticketTypeId,

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
        summary = "Get public ticket types for event",
        description = "Retrieves all available ticket types for a published event accessible to the public",
        operationId = "getPublicTicketTypesForEvent"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Ticket types retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Event not found or not published",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/events/{eventId}/public")
    @ResponseStatus(HttpStatus.OK)
    List<TicketTypeResponse> getPublicTicketTypesForEvent(
        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId
    );

    @Operation(
        summary = "Get public ticket type details",
        description = "Retrieves detailed information about a specific ticket type for a published event",
        operationId = "getPublicTicketType"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Ticket type retrieved successfully",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TicketTypeResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ticket type or event not found, or not published",
            content = @Content(mediaType = "application/json")
        )
    })
    @GetMapping("/{ticketTypeId}/events/{eventId}/public")
    @ResponseStatus(HttpStatus.OK)
    TicketTypeResponse getPublicTicketType(
        @Parameter(
            description = "Ticket type unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174002",
            in = ParameterIn.PATH
        )
        @PathVariable UUID ticketTypeId,

        @Parameter(
            description = "Event unique identifier",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174001",
            in = ParameterIn.PATH
        )
        @PathVariable UUID eventId
    );
} 