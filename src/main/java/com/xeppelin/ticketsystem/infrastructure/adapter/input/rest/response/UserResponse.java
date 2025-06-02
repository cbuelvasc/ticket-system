package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

/**
 * Generic Response DTO for User information.
 * <p>
 * This record provides a unified representation of user data that can be used
 * for organizers, attendees, staff, and other user types in event responses.
 * This approach eliminates code duplication and provides a consistent API.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Schema(description = "User information")
public record UserResponse(
    @Schema(description = "User unique identifier", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id,

    @Schema(description = "User name", example = "John Doe")
    String name,

    @Schema(description = "User email", example = "user@example.com")
    String email
) {

    /**
     * Factory method to create a UserResponse for an organizer context.
     * This provides semantic clarity when the response represents an organizer.
     *
     * @param id the organizer ID
     * @param name the organizer name
     * @param email the organizer email
     * @return a UserResponse representing an organizer
     */
    public static UserResponse forOrganizer(UUID id, String name, String email) {
        return new UserResponse(id, name, email);
    }

    /**
     * Factory method to create a UserResponse for an attendee context.
     * This provides semantic clarity when the response represents an attendee.
     *
     * @param id the attendee ID
     * @param name the attendee name
     * @param email the attendee email
     * @return a UserResponse representing an attendee
     */
    public static UserResponse forAttendee(UUID id, String name, String email) {
        return new UserResponse(id, name, email);
    }

    /**
     * Factory method to create a UserResponse for a staff context.
     * This provides semantic clarity when the response represents a staff member.
     *
     * @param id the staff ID
     * @param name the staff name
     * @param email the staff email
     * @return a UserResponse representing a staff member
     */
    public static UserResponse forStaff(UUID id, String name, String email) {
        return new UserResponse(id, name, email);
    }
} 