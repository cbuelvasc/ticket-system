package com.xeppelin.ticketsystem.domain.service.impl;

import com.xeppelin.ticketsystem.application.port.output.EventRepository;
import com.xeppelin.ticketsystem.application.port.output.UserRepository;
import com.xeppelin.ticketsystem.domain.exception.EventDeletionException;
import com.xeppelin.ticketsystem.domain.exception.EventUpdateException;
import com.xeppelin.ticketsystem.domain.exception.EventValidationException;
import com.xeppelin.ticketsystem.domain.exception.NotFoundException;
import com.xeppelin.ticketsystem.domain.exception.UserNotFoundException;
import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.domain.service.EventService;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of EventService that provides event management operations.
 * <p>
 * This service handles both organizer-specific operations and public event operations
 * using output ports following hexagonal architecture principles.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, Event event) {
        log.debug("Creating event for organizer: {} with staff: {}", organizerId, 
                 event != null && event.getStaff() != null ? event.getStaff().size() : 0);

        // Validate input parameters
        validateCreateEventInput(organizerId, event);

        // Find and validate organizer
        User organizer = userRepository.findById(organizerId)
            .orElseThrow(() -> new UserNotFoundException(
                String.format("User with ID '%s' not found", organizerId)));

        // Resolve and validate staff members if provided
        List<User> resolvedStaff = null;
        if (event.getStaff() != null && !event.getStaff().isEmpty()) {
            resolvedStaff = resolveStaffMembers(event.getStaff());
        }

        // Prepare event for creation
        Event eventToCreate = prepareEventForCreation(event, organizer, resolvedStaff);

        // Debug log to verify staff is included
        log.debug("Event to create - Staff count: {}, Staff IDs: {}", 
                 eventToCreate.getStaff() != null ? eventToCreate.getStaff().size() : 0,
                 eventToCreate.getStaff() != null ? 
                     eventToCreate.getStaff().stream().map(User::getId).toList() : "null");

        // Save event
        Event createdEvent = eventRepository.save(eventToCreate);
        
        // Debug log to verify staff is persisted
        log.debug("Event created - Staff count: {}, Staff IDs: {}", 
                 createdEvent.getStaff() != null ? createdEvent.getStaff().size() : 0,
                 createdEvent.getStaff() != null ? 
                     createdEvent.getStaff().stream().map(User::getId).toList() : "null");
        
        log.info("Event created successfully with ID: {} with {} staff members", 
                createdEvent.getId(), resolvedStaff != null ? resolvedStaff.size() : 0);

        return createdEvent;
    }

    @Override
    public Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable) {
        log.debug("Listing events for organizer: {}", organizerId);

        validateOrganizerId(organizerId);

        return eventRepository.findByOrganizerId(organizerId, pageable);
    }

    @Override
    public Event getEventForOrganizer(UUID organizerId, UUID id) {
        log.debug("Getting event {} for organizer: {}", id, organizerId);

        validateOrganizerId(organizerId);
        validateEventId(id);

        return eventRepository.findByIdAndOrganizerId(id, organizerId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Event with ID '%s' not found for organizer '%s'", id, organizerId)));
    }

    @Override
    public Event updateEventForOrganizer(UUID organizerId, UUID id, Event event) {
        log.debug("Updating event {} for organizer: {}", id, organizerId);

        // Validate input parameters
        validateUpdateEventInput(organizerId, id, event);

        // Find existing event
        Event existingEvent = eventRepository.findByIdAndOrganizerId(id, organizerId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Event with ID '%s' not found for organizer '%s'", id, organizerId)));

        // Validate business rules for update
        validateEventUpdateRules(existingEvent, event);

        // Update event with new data
        Event updatedEvent = mergeEventData(existingEvent, event);

        // Save updated event
        Event result = eventRepository.save(updatedEvent);
        log.info("Event {} updated successfully for organizer: {}", id, organizerId);

        return result;
    }

    @Override
    public void deleteEventForOrganizer(UUID organizerId, UUID id) {
        log.debug("Deleting event {} for organizer: {}", id, organizerId);

        validateOrganizerId(organizerId);
        validateEventId(id);

        // Verify event exists and belongs to organizer
        Event event = eventRepository.findByIdAndOrganizerId(id, organizerId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Event with ID '%s' not found for organizer '%s'", id, organizerId)));

        // Validate business rules for deletion
        validateEventDeletionRules(event);

        eventRepository.delete(event);
        log.info("Event {} deleted successfully for organizer: {}", id, organizerId);
    }

    @Override
    public Page<Event> listPublishedEvents(Pageable pageable) {
        log.debug("Listing published events");

        return eventRepository.findByStatus(EventStatusEnum.PUBLISHED, pageable);
    }

    @Override
    public Page<Event> searchPublishedEvents(String query, Pageable pageable) {
        log.debug("Searching published events with query: {}", query);

        validateSearchQuery(query);

        return eventRepository.searchEvents(query.trim(), pageable);
    }

    @Override
    public Event getPublishedEvent(UUID id) {
        log.debug("Getting published event: {}", id);

        validateEventId(id);

        return eventRepository.findByIdAndStatus(id, EventStatusEnum.PUBLISHED)
            .orElseThrow(() -> new NotFoundException(
                String.format("Published event with ID '%s' not found", id)));
    }

    // Private helper methods

    private List<User> resolveStaffMembers(List<User> partialStaff) {
        log.debug("Resolving {} staff members to full user objects", partialStaff.size());
        
        List<User> resolvedStaff = partialStaff.stream()
            .map(user -> {
                if (user.getId() == null) {
                    throw new IllegalArgumentException("Staff member ID cannot be null");
                }
                return userRepository.findById(user.getId())
                    .orElseThrow(() -> new UserNotFoundException(
                        String.format("Staff member with ID '%s' not found", user.getId())));
            })
            .toList();
            
        log.debug("Successfully resolved {} staff members", resolvedStaff.size());
        return resolvedStaff;
    }

    private void validateCreateEventInput(UUID organizerId, Event event) {
        validateOrganizerId(organizerId);

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        validateEventBusinessRules(event);
    }

    private void validateUpdateEventInput(UUID organizerId, UUID id, Event event) {
        validateOrganizerId(organizerId);
        validateEventId(id);

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        validateEventBusinessRules(event);
    }

    private void validateOrganizerId(UUID organizerId) {
        if (organizerId == null) {
            throw new IllegalArgumentException("Organizer ID cannot be null");
        }
    }

    private void validateEventId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Event ID cannot be null");
        }
    }

    private void validateSearchQuery(String query) {
        if (!StringUtils.hasText(query)) {
            throw new IllegalArgumentException("Search query cannot be null or empty");
        }
    }

    private void validateEventBusinessRules(Event event) {
        if (!StringUtils.hasText(event.getName())) {
            throw new EventValidationException("Event name cannot be null or empty");
        }

        if (event.getStart() == null) {
            throw new EventValidationException("Event start date cannot be null");
        }

        if (event.getEnd() == null) {
            throw new EventValidationException("Event end date cannot be null");
        }

        if (event.getStart().isAfter(event.getEnd())) {
            throw new EventValidationException("Event start date must be before end date");
        }

        if (!StringUtils.hasText(event.getVenue())) {
            throw new EventValidationException("Event venue cannot be null or empty");
        }

        // Validate sales dates if provided
        if (event.getSalesStart() != null && event.getSalesEnd() != null) {
            if (event.getSalesStart().isAfter(event.getSalesEnd())) {
                throw new EventValidationException("Sales start date must be before sales end date");
            }

            if (event.getSalesEnd().isAfter(event.getStart())) {
                throw new EventValidationException("Sales must end before the event starts");
            }
        }
    }

    private Event prepareEventForCreation(Event event, User organizer, List<User> staff) {
        return Event.builder()
            .id(UUID.randomUUID())
            .name(event.getName())
            .start(event.getStart())
            .end(event.getEnd())
            .venue(event.getVenue())
            .salesStart(event.getSalesStart())
            .salesEnd(event.getSalesEnd())
            .status(event.getStatus() != null ? event.getStatus() : EventStatusEnum.DRAFT)
            .organizer(organizer)
            .ticketTypes(event.getTicketTypes())
            .staff(staff)
            .build();
    }

    private void validateEventUpdateRules(Event existingEvent, Event updateData) {
        // Business rule: Cannot update published events past certain point
        if (existingEvent.getStatus() == EventStatusEnum.PUBLISHED &&
            updateData.getStart() != null &&
            updateData.getStart().isBefore(ZonedDateTime.now())) {
            throw new EventUpdateException("Cannot update events that have already started");
        }

        // Business rule: Cannot update cancelled or completed events
        if (existingEvent.getStatus() == EventStatusEnum.CANCELLED ||
            existingEvent.getStatus() == EventStatusEnum.COMPLETED) {
            throw new EventUpdateException("Cannot update cancelled or completed events");
        }
    }

    private Event mergeEventData(Event existingEvent, Event updateData) {
        return Event.builder()
            .id(existingEvent.getId())
            .name(updateData.getName() != null ? updateData.getName() : existingEvent.getName())
            .start(updateData.getStart() != null ? updateData.getStart() : existingEvent.getStart())
            .end(updateData.getEnd() != null ? updateData.getEnd() : existingEvent.getEnd())
            .venue(updateData.getVenue() != null ? updateData.getVenue() : existingEvent.getVenue())
            .salesStart(updateData.getSalesStart() != null ? updateData.getSalesStart() : existingEvent.getSalesStart())
            .salesEnd(updateData.getSalesEnd() != null ? updateData.getSalesEnd() : existingEvent.getSalesEnd())
            .status(updateData.getStatus() != null ? updateData.getStatus() : existingEvent.getStatus())
            .organizer(existingEvent.getOrganizer())
            .attendees(updateData.getAttendees() != null ? updateData.getAttendees() : existingEvent.getAttendees())
            .staff(updateData.getStaff() != null ? updateData.getStaff() : existingEvent.getStaff())
            .ticketTypes(updateData.getTicketTypes() != null ? updateData.getTicketTypes() : existingEvent.getTicketTypes())
            .build();
    }

    private void validateEventDeletionRules(Event event) {
        // Business rule: Cannot delete events that have started or are completed
        if (event.getStart() != null && event.getStart().isBefore(ZonedDateTime.now())) {
            throw new EventDeletionException("Cannot delete events that have already started");
        }

        // Business rule: Cannot delete completed events
        if (event.getStatus() == EventStatusEnum.COMPLETED) {
            throw new EventDeletionException("Cannot delete completed events");
        }
    }
}
