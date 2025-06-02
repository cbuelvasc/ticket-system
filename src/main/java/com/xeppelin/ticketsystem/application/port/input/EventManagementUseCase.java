package com.xeppelin.ticketsystem.application.port.input;

import com.xeppelin.ticketsystem.domain.model.Event;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Use case interface for event management operations.
 * <p>
 * This interface defines the contract for event management operations accessible
 * through the application layer. It provides both organizer-specific operations
 * and public operations for event access.
 * </p>
 * <p>
 * The use case follows the hexagonal architecture pattern and acts as an input port
 * for event management functionality.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface EventManagementUseCase {

    // Organizer operations
    
    /**
     * Creates a new event for the specified organizer.
     *
     * @param organizerId the unique identifier of the organizer creating the event
     * @param event the event to be created, must not be null
     * @return the created event with generated ID and timestamps
     * @throws IllegalArgumentException if organizerId is null or event is null
     * @throws com.xeppelin.ticketsystem.domain.exception.UserNotFoundException if organizer not found
     * @throws com.xeppelin.ticketsystem.domain.exception.EventValidationException if event data violates business rules
     */
    Event createEvent(UUID organizerId, Event event);

    /**
     * Retrieves a paginated list of events for a specific organizer.
     *
     * @param organizerId the unique identifier of the organizer
     * @param pageable pagination information including page number, size, and sorting
     * @return a page containing the organizer's events
     * @throws IllegalArgumentException if organizerId is null
     */
    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);

    /**
     * Retrieves a specific event owned by the given organizer.
     *
     * @param organizerId the unique identifier of the organizer
     * @param eventId the unique identifier of the event
     * @return the event if found
     * @throws IllegalArgumentException if organizerId or eventId is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     */
    Event getEventForOrganizer(UUID organizerId, UUID eventId);

    /**
     * Updates an existing event for the specified organizer.
     *
     * @param organizerId the unique identifier of the organizer
     * @param eventId the unique identifier of the event to update
     * @param event the updated event data, must not be null
     * @return the updated event
     * @throws IllegalArgumentException if any parameter is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     * @throws com.xeppelin.ticketsystem.domain.exception.EventValidationException if event data violates business rules
     * @throws com.xeppelin.ticketsystem.domain.exception.EventUpdateException if update violates business rules
     */
    Event updateEventForOrganizer(UUID organizerId, UUID eventId, Event event);

    /**
     * Deletes an event owned by the specified organizer.
     *
     * @param organizerId the unique identifier of the organizer
     * @param eventId the unique identifier of the event to delete
     * @throws IllegalArgumentException if organizerId or eventId is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     * @throws com.xeppelin.ticketsystem.domain.exception.EventDeletionException if deletion violates business rules
     */
    void deleteEventForOrganizer(UUID organizerId, UUID eventId);

    // Public operations
    
    /**
     * Retrieves a paginated list of all published events.
     *
     * @param pageable pagination information including page number, size, and sorting
     * @return a page containing published events
     */
    Page<Event> listPublishedEvents(Pageable pageable);

    /**
     * Searches for published events based on a query string.
     *
     * @param query the search query string, can be partial matches
     * @param pageable pagination information including page number, size, and sorting
     * @return a page containing published events matching the search criteria
     * @throws IllegalArgumentException if query is null or empty
     */
    Page<Event> searchPublishedEvents(String query, Pageable pageable);

    /**
     * Retrieves a specific published event by its ID.
     *
     * @param eventId the unique identifier of the published event
     * @return the published event if found
     * @throws IllegalArgumentException if eventId is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the published event is not found
     */
    Event getPublishedEvent(UUID eventId);
} 