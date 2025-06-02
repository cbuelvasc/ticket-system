package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Standard error response structure for REST API endpoints.
 * <p>
 * This class provides a consistent format for all error responses
 * returned by the API, following Spring Boot error response conventions
 * and including additional contextual information.
 * </p>
 * <p>
 * The structure is inspired by the default Spring Boot error response
 * but enhanced with validation errors and business context.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Standard error response structure")
public class ErrorResponse {

    /**
     * Timestamp when the error occurred.
     */
    @Schema(
        description = "Timestamp when the error occurred",
        example = "2024-01-15T10:30:00Z"
    )
    private ZonedDateTime timestamp;

    /**
     * HTTP status code.
     */
    @Schema(
        description = "HTTP status code",
        example = "404"
    )
    private int status;

    /**
     * HTTP status reason phrase.
     */
    @Schema(
        description = "HTTP status reason phrase",
        example = "Not Found"
    )
    private String error;

    /**
     * Main error message describing what went wrong.
     */
    @Schema(
        description = "Main error message describing what went wrong",
        example = "Published event with ID '123e4567-e89b-12d3-a456-426614174001' not found"
    )
    private String message;

    /**
     * Request path that caused the error.
     */
    @Schema(
        description = "Request path that caused the error",
        example = "/api/v1/events/123e4567-e89b-12d3-a456-426614174001"
    )
    private String path;

    /**
     * List of validation errors (only present for validation failures).
     */
    @Schema(
        description = "List of validation errors (only present for validation failures)",
        example = "[\"name: Event name cannot be null or empty\", \"start: Event start date cannot be null\"]"
    )
    private List<String> validationErrors;

    /**
     * Additional details about the error (optional).
     */
    @Schema(
        description = "Additional details about the error",
        example = "The requested event may have been deleted or is not in published status"
    )
    private String details;

    /**
     * Error code for client-side handling (optional).
     */
    @Schema(
        description = "Error code for client-side handling",
        example = "EVENT_NOT_FOUND"
    )
    private String errorCode;
} 