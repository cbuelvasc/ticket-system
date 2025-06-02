package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.impl;

import com.xeppelin.ticketsystem.application.port.input.EventManagementUseCase;
import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.IEventController;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.mapper.EventRestMapper;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.UpdateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventSummaryResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller implementation for Event management operations.
 * <p>
 * This controller implements the {@link IEventController} interface and provides
 * the business logic for event management operations. It delegates the actual
 * domain operations to the appropriate use cases and handles the HTTP layer concerns.
 * </p>
 * <p>
 * The implementation focuses solely on:
 * <ul>
 *   <li>HTTP request/response handling</li>
 *   <li>DTO conversions using mappers</li>
 *   <li>Delegation to use cases</li>
 *   <li>Logging and monitoring</li>
 * </ul>
 * </p>
 * <p>
 * Note: Ticket type management operations have been moved to {@code TicketTypeControllerImpl}
 * following REST API best practices for resource separation.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class EventControllerImpl implements IEventController {

    private final EventManagementUseCase eventManagementUseCase;

    private final EventRestMapper eventRestMapper;

    // =====================================================
    // ORGANIZER OPERATIONS
    // =====================================================

    @Override
    public EventResponse createEvent(UUID organizerId, CreateEventRequest request) {
        log.info("Creating event for organizer: {}", organizerId);

        Event eventToCreate = eventRestMapper.fromCreateRequestToEvent(request);
        Event createdEvent = eventManagementUseCase.createEvent(organizerId, eventToCreate);
        EventResponse response = eventRestMapper.fromEventToEventResponse(createdEvent);

        log.info("Event created successfully with ID: {} for organizer: {}", createdEvent.getId(), organizerId);
        return response;
    }

    @Override
    public Page<EventSummaryResponse> listEventsForOrganizer(UUID organizerId, Pageable pageable) {
        log.debug("Listing events for organizer: {} with pagination: {}", organizerId, pageable);

        Page<Event> events = eventManagementUseCase.listEventsForOrganizer(organizerId, pageable);
        Page<EventSummaryResponse> response = events.map(eventRestMapper::fromEventToEventSummaryResponse);

        log.debug("Found {} events for organizer: {}", events.getTotalElements(), organizerId);
        return response;
    }

    @Override
    public EventResponse getEventForOrganizer(UUID eventId, UUID organizerId) {
        log.debug("Getting event {} for organizer: {}", eventId, organizerId);

        Event event = eventManagementUseCase.getEventForOrganizer(organizerId, eventId);
        EventResponse response = eventRestMapper.fromEventToEventResponse(event);

        log.debug("Event {} retrieved successfully for organizer: {}", eventId, organizerId);
        return response;
    }

    @Override
    public EventResponse updateEventForOrganizer(UUID eventId, UUID organizerId, UpdateEventRequest request) {
        log.info("Updating event {} for organizer: {}", eventId, organizerId);

        Event eventToUpdate = eventRestMapper.fromUpdateRequestToEvent(request);
        Event updatedEvent = eventManagementUseCase.updateEventForOrganizer(organizerId, eventId, eventToUpdate);
        EventResponse response = eventRestMapper.fromEventToEventResponse(updatedEvent);

        log.info("Event {} updated successfully for organizer: {}", eventId, organizerId);
        return response;
    }

    @Override
    public void deleteEventForOrganizer(UUID eventId, UUID organizerId) {
        log.info("Deleting event {} for organizer: {}", eventId, organizerId);

        eventManagementUseCase.deleteEventForOrganizer(organizerId, eventId);

        log.info("Event {} deleted successfully for organizer: {}", eventId, organizerId);
    }

    // =====================================================
    // PUBLIC OPERATIONS
    // =====================================================

    @Override
    public Page<EventSummaryResponse> listPublishedEvents(Pageable pageable) {
        log.debug("Listing published events with pagination: {}", pageable);

        Page<Event> events = eventManagementUseCase.listPublishedEvents(pageable);
        Page<EventSummaryResponse> response = events.map(eventRestMapper::fromEventToEventSummaryResponse);

        log.debug("Found {} published events", events.getTotalElements());
        return response;
    }

    @Override
    public Page<EventSummaryResponse> searchEvents(String query, Pageable pageable) {
        log.debug("Searching published events with query: '{}' and pagination: {}", query, pageable);

        Page<Event> events = eventManagementUseCase.searchPublishedEvents(query, pageable);
        Page<EventSummaryResponse> response = events.map(eventRestMapper::fromEventToEventSummaryResponse);

        log.debug("Found {} events matching query: '{}'", events.getTotalElements(), query);
        return response;
    }

    @Override
    public EventResponse getPublishedEvent(UUID eventId) {
        log.debug("Getting published event: {}", eventId);

        Event event = eventManagementUseCase.getPublishedEvent(eventId);
        EventResponse response = eventRestMapper.fromEventToEventResponse(event);

        log.debug("Published event {} retrieved successfully", eventId);
        return response;
    }
} 