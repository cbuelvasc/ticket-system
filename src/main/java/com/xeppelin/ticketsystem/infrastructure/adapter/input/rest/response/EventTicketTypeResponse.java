package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response DTO for Ticket Type information in Event responses.
 * <p>
 * This record provides simplified ticket type data for event responses,
 * without calculated fields like sold quantity or availability.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Schema(description = "Ticket type information for event responses")
public record EventTicketTypeResponse(
    @Schema(description = "Ticket type unique identifier", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id,

    @Schema(description = "Ticket type name", example = "VIP")
    String name,

    @Schema(description = "Ticket price", example = "99.99")
    BigDecimal price,

    @Schema(description = "Ticket type description", example = "VIP access with premium seating")
    String description,

    @Schema(description = "Total available quantity", example = "100")
    Integer totalAvailable
) {
} 