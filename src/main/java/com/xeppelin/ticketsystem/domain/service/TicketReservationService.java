package com.xeppelin.ticketsystem.domain.service;

import com.xeppelin.ticketsystem.domain.model.TicketReservation;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for managing temporary ticket reservations.
 * <p>
 * This service handles the complete lifecycle of ticket reservations including:
 * </p>
 * <ul>
 *   <li>Creating temporary holds on tickets</li>
 *   <li>Managing reservation expiration</li>
 *   <li>Converting reservations to actual tickets</li>
 *   <li>Cleaning up expired reservations</li>
 * </ul>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface TicketReservationService {

    /**
     * Default reservation duration - 15 minutes.
     */
    Duration DEFAULT_RESERVATION_DURATION = Duration.ofMinutes(15);

    /**
     * Creates a new ticket reservation for the specified parameters.
     * 
     * @param eventId the event for which to reserve tickets
     * @param ticketTypeId the type of ticket to reserve
     * @param quantity number of tickets to reserve
     * @param sessionId session identifier of the user
     * @param userId user ID (optional, can be null for anonymous reservations)
     * @param reservationDuration how long to hold the reservation
     * @return the created reservation
     * @throws IllegalArgumentException if parameters are invalid
     * @throws com.xeppelin.ticketsystem.domain.exception.InsufficientTicketsException if not enough tickets available
     */
    TicketReservation createReservation(UUID eventId, UUID ticketTypeId, Integer quantity, 
                                       String sessionId, UUID userId, Duration reservationDuration);

    /**
     * Creates a reservation with default duration (15 minutes).
     *
     * @param eventId the event for which to reserve tickets
     * @param ticketTypeId the type of ticket to reserve
     * @param quantity number of tickets to reserve
     * @param sessionId session identifier of the user
     * @param userId user ID (optional, can be null for anonymous reservations)
     * @return the created reservation
     * @throws IllegalArgumentException if parameters are invalid
     * @throws com.xeppelin.ticketsystem.domain.exception.InsufficientTicketsException if not enough tickets available
     */
    default TicketReservation createReservation(UUID eventId, UUID ticketTypeId, Integer quantity, 
                                              String sessionId, UUID userId) {
        return createReservation(eventId, ticketTypeId, quantity, sessionId, userId, DEFAULT_RESERVATION_DURATION);
    }

    /**
     * Confirms a reservation and converts it to actual ticket purchase.
     * 
     * @param reservationId the reservation to confirm
     * @return the confirmed reservation
     * @throws com.xeppelin.ticketsystem.domain.exception.ReservationNotFoundException if reservation not found
     * @throws com.xeppelin.ticketsystem.domain.exception.ReservationExpiredException if reservation expired
     * @throws IllegalStateException if reservation is not in confirmable state
     */
    TicketReservation confirmReservation(UUID reservationId);

    /**
     * Cancels an active reservation, making tickets available immediately.
     * 
     * @param reservationId the reservation to cancel
     * @param sessionId session ID of the user (for security)
     * @return the cancelled reservation
     * @throws com.xeppelin.ticketsystem.domain.exception.ReservationNotFoundException if reservation not found
     * @throws com.xeppelin.ticketsystem.domain.exception.UnauthorizedOperationException if session doesn't match
     */
    TicketReservation cancelReservation(UUID reservationId, String sessionId);

    /**
     * Extends an active reservation by the specified duration.
     * 
     * @param reservationId the reservation to extend
     * @param sessionId session ID of the user (for security)
     * @param additionalDuration additional time to add to the reservation
     * @return the extended reservation
     * @throws com.xeppelin.ticketsystem.domain.exception.ReservationNotFoundException if reservation not found
     * @throws com.xeppelin.ticketsystem.domain.exception.UnauthorizedOperationException if session doesn't match
     * @throws IllegalStateException if reservation cannot be extended
     */
    TicketReservation extendReservation(UUID reservationId, String sessionId, Duration additionalDuration);

    /**
     * Retrieves a reservation by ID.
     * 
     * @param reservationId the reservation ID
     * @return optional containing the reservation if found
     * @throws IllegalArgumentException if reservationId is null
     */
    Optional<TicketReservation> getReservation(UUID reservationId);

    /**
     * Gets all active reservations for a user session.
     * 
     * @param sessionId the session ID
     * @return list of active reservations for the session
     * @throws IllegalArgumentException if sessionId is null or empty
     */
    List<TicketReservation> getActiveReservationsForSession(String sessionId);

    /**
     * Gets all active reservations for a ticket type.
     * <p>
     * Used for calculating available tickets.
     * </p>
     * 
     * @param ticketTypeId the ticket type ID
     * @return list of active reservations for the ticket type
     * @throws IllegalArgumentException if ticketTypeId is null
     */
    List<TicketReservation> getActiveReservationsForTicketType(UUID ticketTypeId);

    /**
     * Processes expired reservations and marks them as expired.
     * <p>
     * This should be called periodically by a scheduled task.
     * </p>
     * 
     * @return number of reservations that were expired
     */
    int processExpiredReservations();

    /**
     * Calculates available tickets for a ticket type considering active reservations.
     * 
     * @param ticketTypeId the ticket type ID
     * @return number of tickets available for reservation
     * @throws IllegalArgumentException if ticketTypeId is null
     */
    int getAvailableTicketCount(UUID ticketTypeId);

    /**
     * Checks if a user session has reached the maximum allowed reservations.
     * 
     * @param sessionId the session ID
     * @return true if the session has reached the limit
     */
    boolean hasReachedReservationLimit(String sessionId);
} 