package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Request DTO for updating an existing ticket type.
 * <p>
 * This record defines the structure for updating ticket types.
 * All fields are optional - only provided fields will be updated.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Schema(description = "Request to update a ticket type")
public record UpdateTicketTypeRequest(
    
    @Schema(description = "Ticket type name", example = "VIP Premium", maxLength = 255)
    @Size(max = 255, message = "Ticket type name cannot exceed 255 characters")
    String name,

    @Schema(description = "Ticket price", example = "129.99")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    BigDecimal price,

    @Schema(description = "Ticket type description", example = "VIP access with premium seating and complimentary drinks", maxLength = 1000)
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    String description,

    @Schema(description = "Total available quantity", example = "150")
    @Min(value = 1, message = "Total available must be at least 1")
    Integer totalAvailable
) {
} 