package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.exception;

import com.xeppelin.ticketsystem.domain.exception.EventValidationException;
import com.xeppelin.ticketsystem.domain.exception.NotFoundException;
import com.xeppelin.ticketsystem.domain.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Test class for GlobalExceptionHandler.
 * <p>
 * This class tests the exception handling behavior of the global exception handler,
 * ensuring that domain exceptions are correctly converted to appropriate HTTP responses.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @Mock
    private HttpServletRequest request;

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
        when(request.getRequestURI()).thenReturn("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
    }

    @Test
    void handleNotFoundException_ShouldReturnNotFoundResponse() {
        // Given
        String errorMessage = "Published event with ID '123e4567-e89b-12d3-a456-426614174001' not found";
        NotFoundException exception = new NotFoundException(errorMessage);

        // When
        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleNotFoundException(exception, request);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(404);
        assertThat(response.getBody().getError()).isEqualTo("Not Found");
        assertThat(response.getBody().getMessage()).isEqualTo(errorMessage);
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
        assertThat(response.getBody().getErrorCode()).isEqualTo("RESOURCE_NOT_FOUND");
        assertThat(response.getBody().getTimestamp()).isNotNull();
    }

    @Test
    void handleUserNotFoundException_ShouldReturnNotFoundResponse() {
        // Given
        String errorMessage = "User with ID '123e4567-e89b-12d3-a456-426614174000' not found";
        UserNotFoundException exception = new UserNotFoundException(errorMessage);

        // When
        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleUserNotFoundException(exception, request);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(404);
        assertThat(response.getBody().getError()).isEqualTo("Not Found");
        assertThat(response.getBody().getMessage()).isEqualTo(errorMessage);
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
        assertThat(response.getBody().getErrorCode()).isEqualTo("USER_NOT_FOUND");
        assertThat(response.getBody().getTimestamp()).isNotNull();
    }

    @Test
    void handleEventValidationException_ShouldReturnBadRequestResponse() {
        // Given
        String errorMessage = "Event name cannot be null or empty";
        EventValidationException exception = new EventValidationException(errorMessage);

        // When
        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleEventValidationException(exception, request);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(400);
        assertThat(response.getBody().getError()).isEqualTo("Bad Request");
        assertThat(response.getBody().getMessage()).isEqualTo(errorMessage);
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
        assertThat(response.getBody().getErrorCode()).isEqualTo("EVENT_VALIDATION_FAILED");
        assertThat(response.getBody().getTimestamp()).isNotNull();
    }

    @Test
    void handleIllegalArgumentException_ShouldReturnBadRequestResponse() {
        // Given
        String errorMessage = "Event ID cannot be null";
        IllegalArgumentException exception = new IllegalArgumentException(errorMessage);

        // When
        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgumentException(exception, request);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(400);
        assertThat(response.getBody().getError()).isEqualTo("Bad Request");
        assertThat(response.getBody().getMessage()).isEqualTo(errorMessage);
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
        assertThat(response.getBody().getErrorCode()).isEqualTo("INVALID_ARGUMENT");
        assertThat(response.getBody().getTimestamp()).isNotNull();
    }

    @Test
    void handleGenericException_ShouldReturnInternalServerErrorResponse() {
        // Given
        String errorMessage = "Something went wrong";
        RuntimeException exception = new RuntimeException(errorMessage);

        // When
        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleGenericException(exception, request);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(500);
        assertThat(response.getBody().getError()).isEqualTo("Internal Server Error");
        assertThat(response.getBody().getMessage()).isEqualTo("An unexpected error occurred");
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/events/123e4567-e89b-12d3-a456-426614174001");
        assertThat(response.getBody().getErrorCode()).isEqualTo("INTERNAL_SERVER_ERROR");
        assertThat(response.getBody().getTimestamp()).isNotNull();
    }
} 