package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Request DTO for creating a new ticket type.
 * <p>
 * This record defines the structure for creating ticket types
 * for an existing event.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Schema(description = "Request to create a ticket type")
public record CreateTicketTypeRequest(
    
    @Schema(description = "Ticket type name", example = "VIP", required = true, maxLength = 255)
    @NotBlank(message = "Ticket type name is required")
    @Size(max = 255, message = "Ticket type name cannot exceed 255 characters")
    String name,

    @Schema(description = "Ticket price", example = "99.99", required = true)
    @NotNull(message = "Ticket price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    BigDecimal price,

    @Schema(description = "Ticket type description", example = "VIP access with premium seating", maxLength = 1000)
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    String description,

    @Schema(description = "Total available quantity", example = "100")
    @Min(value = 1, message = "Total available must be at least 1")
    Integer totalAvailable
) {
} 