package com.xeppelin.ticketsystem.application.port.output;

import com.xeppelin.ticketsystem.domain.model.TicketReservation;
import com.xeppelin.ticketsystem.domain.model.TicketReservationStatusEnum;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for TicketReservation repository operations.
 * <p>
 * This interface defines the contract for ticket reservation data access operations
 * following the hexagonal architecture pattern.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface TicketReservationRepository {

    /**
     * Saves a ticket reservation.
     *
     * @param reservation the reservation to save
     * @return the saved reservation
     * @throws IllegalArgumentException if reservation is null
     */
    TicketReservation save(TicketReservation reservation);

    /**
     * Finds a reservation by ID.
     *
     * @param reservationId the reservation's unique identifier
     * @return optional containing the reservation if found
     * @throws IllegalArgumentException if reservationId is null
     */
    Optional<TicketReservation> findById(UUID reservationId);

    /**
     * Finds reservations by session ID and status.
     *
     * @param sessionId the session identifier
     * @param status the reservation status
     * @return list of reservations
     * @throws IllegalArgumentException if sessionId is null or empty, or status is null
     */
    List<TicketReservation> findBySessionIdAndStatus(String sessionId, TicketReservationStatusEnum status);

    /**
     * Finds reservations by ticket type ID and status.
     *
     * @param ticketTypeId the ticket type identifier
     * @param status the reservation status
     * @return list of reservations
     * @throws IllegalArgumentException if ticketTypeId or status is null
     */
    List<TicketReservation> findByTicketTypeIdAndStatus(UUID ticketTypeId, TicketReservationStatusEnum status);

    /**
     * Finds a reservation by ID and session ID.
     *
     * @param reservationId the reservation identifier
     * @param sessionId the session identifier
     * @return optional containing the reservation if found and belongs to session
     * @throws IllegalArgumentException if reservationId is null or sessionId is null or empty
     */
    Optional<TicketReservation> findByIdAndSessionId(UUID reservationId, String sessionId);

    /**
     * Finds expired active reservations.
     *
     * @param currentTime the current time to compare against
     * @return list of expired reservations
     * @throws IllegalArgumentException if currentTime is null
     */
    List<TicketReservation> findExpiredActiveReservations(ZonedDateTime currentTime);

    /**
     * Counts active reservations for a session.
     *
     * @param sessionId the session identifier
     * @return number of active reservations
     * @throws IllegalArgumentException if sessionId is null or empty
     */
    long countActiveReservationsBySession(String sessionId);

    /**
     * Sums the quantity of active reservations for a ticket type.
     *
     * @param ticketTypeId the ticket type identifier
     * @return total quantity of active reservations
     * @throws IllegalArgumentException if ticketTypeId is null
     */
    Integer sumActiveReservationQuantityByTicketType(UUID ticketTypeId);

    /**
     * Checks if a reservation exists for session, ticket type and status.
     *
     * @param sessionId the session identifier
     * @param ticketTypeId the ticket type identifier
     * @param status the reservation status
     * @return true if such reservation exists
     * @throws IllegalArgumentException if any parameter is null or sessionId is empty
     */
    boolean existsBySessionIdAndTicketTypeIdAndStatus(String sessionId, UUID ticketTypeId, TicketReservationStatusEnum status);

    /**
     * Marks multiple reservations as expired in batch.
     *
     * @param reservationIds list of reservation IDs to mark as expired
     * @param releasedAt timestamp when they were released
     * @return number of reservations updated
     * @throws IllegalArgumentException if reservationIds is null or empty, or releasedAt is null
     */
    int markReservationsAsExpired(List<UUID> reservationIds, ZonedDateTime releasedAt);

    /**
     * Deletes a reservation.
     *
     * @param reservation the reservation to delete
     * @throws IllegalArgumentException if reservation is null
     */
    void delete(TicketReservation reservation);
}
