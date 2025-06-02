package com.xeppelin.ticketsystem.application.port.output;

import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Output port for Event repository operations.
 * <p>
 * This interface defines the contract for event data access operations
 * following the hexagonal architecture pattern.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface EventRepository {

    /**
     * Saves an event.
     *
     * @param event the event to save
     * @return the saved event
     * @throws IllegalArgumentException if event is null
     */
    Event save(Event event);

    /**
     * Finds events by organizer ID with pagination.
     *
     * @param organizerId the organizer's unique identifier
     * @param pageable pagination information
     * @return page of events
     * @throws IllegalArgumentException if organizerId is null
     */
    Page<Event> findByOrganizerId(UUID organizerId, Pageable pageable);

    /**
     * Finds an event by ID and organizer ID.
     *
     * @param eventId the event's unique identifier
     * @param organizerId the organizer's unique identifier
     * @return optional containing the event if found
     * @throws IllegalArgumentException if eventId or organizerId is null
     */
    Optional<Event> findByIdAndOrganizerId(UUID eventId, UUID organizerId);

    /**
     * Finds events by status with pagination.
     *
     * @param status the event status
     * @param pageable pagination information
     * @return page of events
     * @throws IllegalArgumentException if status is null
     */
    Page<Event> findByStatus(EventStatusEnum status, Pageable pageable);

    /**
     * Searches events by text query with pagination.
     *
     * @param searchTerm the search term
     * @param pageable pagination information
     * @return page of events matching the search
     * @throws IllegalArgumentException if searchTerm is null or empty
     */
    Page<Event> searchEvents(String searchTerm, Pageable pageable);

    /**
     * Finds an event by ID and status.
     *
     * @param eventId the event's unique identifier
     * @param status the required status
     * @return optional containing the event if found
     * @throws IllegalArgumentException if eventId or status is null
     */
    Optional<Event> findByIdAndStatus(UUID eventId, EventStatusEnum status);

    /**
     * Deletes an event.
     *
     * @param event the event to delete
     * @throws IllegalArgumentException if event is null
     */
    void delete(Event event);
} 