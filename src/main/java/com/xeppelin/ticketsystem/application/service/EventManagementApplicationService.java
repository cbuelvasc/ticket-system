package com.xeppelin.ticketsystem.application.service;

import com.xeppelin.ticketsystem.application.port.input.EventManagementUseCase;
import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.service.EventService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Application service implementation for event management operations.
 * <p>
 * This service acts as an orchestrator for event-related use cases, delegating
 * domain operations to the appropriate domain services. It implements the
 * EventManagementUseCase input port and serves as the entry point for event
 * management functionality in the application layer.
 * </p>
 * <p>
 * The service provides both organizer-specific operations (full CRUD) and
 * public operations (read-only access to published events) following the
 * hexagonal architecture pattern.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EventManagementApplicationService implements EventManagementUseCase {

    private final EventService eventService;

    @Override
    @Transactional
    public Event createEvent(UUID organizerId, Event event) {
        log.info("Creating event for organizer: {}", organizerId);
        log.debug("Event details: name={}, venue={}, start={}, end={}, staff={}",
            event != null ? event.getName() : null,
            event != null ? event.getVenue() : null,
            event != null ? event.getStart() : null,
            event != null ? event.getEnd() : null,
            event != null && event.getStaff() != null ? event.getStaff().size() : 0);

        Event createdEvent = eventService.createEvent(organizerId, event);
        log.info("Event created successfully with ID: {} for organizer: {} with {} staff members",
            createdEvent.getId(), organizerId, 
            createdEvent.getStaff() != null ? createdEvent.getStaff().size() : 0);
        return createdEvent;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable) {
        log.debug("Listing events for organizer: {} with pagination: {}", organizerId, pageable);

        Page<Event> events = eventService.listEventsForOrganizer(organizerId, pageable);
        log.debug("Found {} events for organizer: {}", events.getTotalElements(), organizerId);
        return events;
    }

    @Override
    @Transactional(readOnly = true)
    public Event getEventForOrganizer(UUID organizerId, UUID eventId) {
        log.debug("Getting event {} for organizer: {}", eventId, organizerId);

        Event event = eventService.getEventForOrganizer(organizerId, eventId);
        log.debug("Event {} found for organizer: {}", eventId, organizerId);
        return event;
    }

    @Override
    @Transactional
    public Event updateEventForOrganizer(UUID organizerId, UUID eventId, Event event) {
        log.info("Updating event {} for organizer: {}", eventId, organizerId);
        log.debug("Updated event details: name={}, venue={}, start={}, end={}",
            event != null ? event.getName() : null,
            event != null ? event.getVenue() : null,
            event != null ? event.getStart() : null,
            event != null ? event.getEnd() : null);

        Event updatedEvent = eventService.updateEventForOrganizer(organizerId, eventId, event);
        log.info("Event {} updated successfully for organizer: {}", eventId, organizerId);
        return updatedEvent;
    }

    @Override
    @Transactional
    public void deleteEventForOrganizer(UUID organizerId, UUID eventId) {
        log.info("Deleting event {} for organizer: {}", eventId, organizerId);

        eventService.deleteEventForOrganizer(organizerId, eventId);
        log.info("Event {} deleted successfully for organizer: {}", eventId, organizerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Event> listPublishedEvents(Pageable pageable) {
        log.debug("Listing published events with pagination: {}", pageable);

        Page<Event> events = eventService.listPublishedEvents(pageable);
        log.debug("Found {} published events", events.getTotalElements());
        return events;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Event> searchPublishedEvents(String query, Pageable pageable) {
        log.debug("Searching published events with query: '{}' and pagination: {}", query, pageable);

        Page<Event> events = eventService.searchPublishedEvents(query, pageable);
        log.debug("Found {} published events matching query: '{}'", events.getTotalElements(), query);
        return events;
    }

    @Override
    @Transactional(readOnly = true)
    public Event getPublishedEvent(UUID eventId) {
        log.debug("Getting published event: {}", eventId);

        Event event = eventService.getPublishedEvent(eventId);
        log.debug("Published event {} found", eventId);
        return event;
    }
} 