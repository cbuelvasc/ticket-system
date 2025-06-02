package com.xeppelin.ticketsystem.domain.service;

import com.xeppelin.ticketsystem.domain.model.Event;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for managing events in the ticket system.
 * <p>
 * This service provides operations for event management including CRUD operations
 * for organizers and read-only operations for published events accessible to the public.
 * </p>
 * <p>
 * The service handles two main scopes:
 * <ul>
 *   <li>Organizer-specific operations: Full CRUD operations for events owned by specific organizers</li>
 *   <li>Public operations: Read-only access to published events for general consumers</li>
 * </ul>
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface EventService {

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
     * @param id the unique identifier of the event
     * @return the event if found
     * @throws IllegalArgumentException if organizerId or id is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     */
    Event getEventForOrganizer(UUID organizerId, UUID id);

    /**
     * Updates an existing event for the specified organizer.
     * <p>
     * Only the organizer who owns the event can update it.
     * </p>
     *
     * @param organizerId the unique identifier of the organizer
     * @param id the unique identifier of the event to update
     * @param event the updated event data, must not be null
     * @return the updated event
     * @throws IllegalArgumentException if any parameter is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     * @throws com.xeppelin.ticketsystem.domain.exception.EventValidationException if event data violates business rules
     * @throws com.xeppelin.ticketsystem.domain.exception.EventUpdateException if update violates business rules
     */
    Event updateEventForOrganizer(UUID organizerId, UUID id, Event event);

    /**
     * Deletes an event owned by the specified organizer.
     * <p>
     * This operation is irreversible. Only the organizer who owns the event can delete it.
     * </p>
     *
     * @param organizerId the unique identifier of the organizer
     * @param id the unique identifier of the event to delete
     * @throws IllegalArgumentException if organizerId or id is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the event is not found
     * @throws com.xeppelin.ticketsystem.domain.exception.EventDeletionException if deletion violates business rules
     */
    void deleteEventForOrganizer(UUID organizerId, UUID id);

    /**
     * Retrieves a paginated list of all published events.
     * <p>
     * This method returns only events that have been published and are visible to the public.
     * </p>
     *
     * @param pageable pagination information including page number, size, and sorting
     * @return a page containing published events
     */
    Page<Event> listPublishedEvents(Pageable pageable);

    /**
     * Searches for published events based on a query string.
     * <p>
     * The search is performed on event titles, descriptions, and other searchable fields.
     * Only published events are included in the search results.
     * </p>
     *
     * @param query the search query string, can be partial matches
     * @param pageable pagination information including page number, size, and sorting
     * @return a page containing published events matching the search criteria
     * @throws IllegalArgumentException if query is null or empty
     */
    Page<Event> searchPublishedEvents(String query, Pageable pageable);

    /**
     * Retrieves a specific published event by its ID.
     * <p>
     * This method only returns events that are published and publicly accessible.
     * </p>
     *
     * @param id the unique identifier of the published event
     * @return the published event if found
     * @throws IllegalArgumentException if id is null
     * @throws com.xeppelin.ticketsystem.domain.exception.NotFoundException if the published event is not found
     */
    Event getPublishedEvent(UUID id);
}
