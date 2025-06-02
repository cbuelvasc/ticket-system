package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.mapper;

import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.TicketType;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.UpdateEventRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateTicketTypeRequest;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventSummaryResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.EventTicketTypeResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.TicketTypeResponse;
import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.response.UserResponse;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.AfterMapping;

/**
 * Mapper for converting between Event domain models and REST DTOs.
 * <p>
 * This mapper handles the conversion between domain objects and their
 * corresponding request/response DTOs for REST API operations.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventRestMapper {

    /**
     * Converts a CreateEventRequest to an Event domain model.
     *
     * @param request the create event request
     * @return the event domain model
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizer", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", expression = "java(mapStaffIdsToUsers(request.staffIds()))")
    @Mapping(target = "ticketTypes", expression = "java(mapCreateTicketTypeRequestsToTicketTypes(request.ticketTypes()))")
    @Mapping(target = "status", ignore = true)
    Event fromCreateRequestToEvent(CreateEventRequest request);

    /**
     * After mapping, establish bidirectional relationship between event and ticket types.
     *
     * @param event the mapped event
     */
    @AfterMapping
    default void setEventInTicketTypes(@MappingTarget Event event) {
        if (event.getTicketTypes() != null) {
            event.getTicketTypes().forEach(ticketType -> ticketType.setEvent(event));
        }
    }

    /**
     * Converts an UpdateEventRequest to an Event domain model.
     *
     * @param request the update event request
     * @return the event domain model
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizer", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "ticketTypes", ignore = true)
    Event fromUpdateRequestToEvent(UpdateEventRequest request);

    /**
     * Converts an Event domain model to an EventResponse.
     *
     * @param event the event domain model
     * @return the event response DTO
     */
    @Mapping(target = "staff", expression = "java(mapUsersToUserResponses(event.getStaff()))")
    @Mapping(target = "ticketTypes", expression = "java(mapTicketTypesToEventTicketTypeResponses(event.getTicketTypes()))")
    EventResponse fromEventToEventResponse(Event event);

    /**
     * Converts an Event domain model to an EventSummaryResponse.
     *
     * @param event the event domain model
     * @return the event summary response DTO
     */
    @Mapping(target = "organizerName", source = "organizer.name")
    @Mapping(target = "ticketTypesCount", expression = "java(getTicketTypesCount(event.getTicketTypes()))")
    @Mapping(target = "salesActive", expression = "java(isSalesActive(event.getSalesStart(), event.getSalesEnd()))")
    EventSummaryResponse fromEventToEventSummaryResponse(Event event);

    /**
     * Converts a list of Event domain models to a list of EventSummaryResponse.
     *
     * @param events the list of event domain models
     * @return the list of event summary response DTOs
     */
    List<EventSummaryResponse> fromEventsToEventSummaryResponses(List<Event> events);

    /**
     * Converts a User domain model to a UserResponse.
     *
     * @param user the user domain model
     * @return the user response DTO
     */
    UserResponse fromUserToUserResponse(User user);

    /**
     * Converts a TicketType domain model to a TicketTypeResponse (standalone).
     *
     * @param ticketType the ticket type domain model
     * @return the ticket type response DTO
     */
    @Mapping(target = "soldQuantity", expression = "java(calculateSoldQuantity(ticketType))")
    @Mapping(target = "availableQuantity", expression = "java(calculateAvailableQuantity(ticketType))")
    @Mapping(target = "isAvailable", expression = "java(isTicketTypeAvailable(ticketType))")
    TicketTypeResponse fromTicketTypeToTicketTypeResponse(TicketType ticketType);

    /**
     * Converts a TicketType domain model to an EventTicketTypeResponse (for EventResponse).
     *
     * @param ticketType the ticket type domain model
     * @return the event ticket type response DTO
     */
    EventTicketTypeResponse fromTicketTypeToEventTicketTypeResponse(TicketType ticketType);

    /**
     * Helper method to calculate the number of ticket types.
     *
     * @param ticketTypes the list of ticket types
     * @return the count of ticket types
     */
    default Integer getTicketTypesCount(List<TicketType> ticketTypes) {
        return ticketTypes != null ? ticketTypes.size() : 0;
    }

    /**
     * Helper method to determine if ticket sales are currently active.
     *
     * @param salesStart the sales start date
     * @param salesEnd   the sales end date
     * @return true if sales are active, false otherwise
     */
    default Boolean isSalesActive(ZonedDateTime salesStart, ZonedDateTime salesEnd) {
        ZonedDateTime now = ZonedDateTime.now();

        // If no sales dates are set, assume sales are always active
        if (salesStart == null && salesEnd == null) {
            return true;
        }

        // If only start date is set, sales are active if we're past the start date
        if (salesStart != null && salesEnd == null) {
            return now.isAfter(salesStart) || now.isEqual(salesStart);
        }

        // If only end date is set, sales are active if we're before the end date
        if (salesStart == null && salesEnd != null) {
            return now.isBefore(salesEnd);
        }

        // If both dates are set, sales are active if we're within the range
        return (now.isAfter(salesStart) || now.isEqual(salesStart)) &&
            now.isBefore(salesEnd);
    }

    /**
     * Helper method to convert staff IDs to User objects with only ID set.
     * The service layer will resolve these to full User objects.
     *
     * @param staffIds the list of staff IDs
     * @return the list of User objects with only IDs set
     */
    default List<User> mapStaffIdsToUsers(List<UUID> staffIds) {
        if (staffIds == null || staffIds.isEmpty()) {
            return null;
        }
        
        return staffIds.stream()
            .map(id -> User.builder().id(id).build())
            .toList();
    }

    /**
     * Helper method to convert Users to UserResponses.
     *
     * @param users the list of users
     * @return the list of user response DTOs
     */
    default List<UserResponse> mapUsersToUserResponses(List<User> users) {
        if (users == null || users.isEmpty()) {
            return null;
        }
        
        return users.stream()
            .map(this::fromUserToUserResponse)
            .toList();
    }

    /**
     * Helper method to convert TicketTypes to EventTicketTypeResponse list.
     *
     * @param ticketTypes the list of ticket types
     * @return the list of event ticket type response DTOs
     */
    default List<EventTicketTypeResponse> mapTicketTypesToEventTicketTypeResponses(List<TicketType> ticketTypes) {
        if (ticketTypes == null || ticketTypes.isEmpty()) {
            return null;
        }
        
        return ticketTypes.stream()
            .map(this::fromTicketTypeToEventTicketTypeResponse)
            .toList();
    }

    /**
     * Helper method to convert CreateTicketTypeRequest list to TicketType list.
     *
     * @param ticketTypeRequests the list of ticket type creation requests
     * @return the list of TicketType objects
     */
    default List<TicketType> mapCreateTicketTypeRequestsToTicketTypes(List<CreateTicketTypeRequest> ticketTypeRequests) {
        if (ticketTypeRequests == null || ticketTypeRequests.isEmpty()) {
            return null;
        }
        
        return ticketTypeRequests.stream()
            .map(this::mapCreateTicketTypeRequestToTicketType)
            .toList();
    }

    /**
     * Helper method to convert a single CreateTicketTypeRequest to TicketType.
     *
     * @param request the ticket type creation request
     * @return the TicketType object
     */
    default TicketType mapCreateTicketTypeRequestToTicketType(CreateTicketTypeRequest request) {
        if (request == null) {
            return null;
        }
        
        return TicketType.builder()
            .id(UUID.randomUUID()) // Generate ID for new ticket type
            .name(request.name())
            .price(request.price())
            .description(request.description())
            .totalAvailable(request.totalAvailable())
            .event(null) // Will be set by the service layer
            .tickets(null) // Empty for new ticket types
            .build();
    }

    /**
     * Helper method to calculate sold quantity for a ticket type.
     *
     * @param ticketType the ticket type
     * @return the number of sold tickets
     */
    default Integer calculateSoldQuantity(TicketType ticketType) {
        if (ticketType == null || ticketType.getTickets() == null) {
            return 0;
        }
        // Count tickets that are not cancelled or expired
        return (int) ticketType.getTickets().stream()
            .filter(ticket -> ticket.getStatus() != null)
            .filter(ticket -> !ticket.getStatus().name().equals("CANCELLED") && !ticket.getStatus().name().equals("EXPIRED"))
            .count();
    }

    /**
     * Helper method to calculate available quantity for a ticket type.
     *
     * @param ticketType the ticket type
     * @return the number of available tickets
     */
    default Integer calculateAvailableQuantity(TicketType ticketType) {
        if (ticketType == null || ticketType.getTotalAvailable() == null) {
            return 0;
        }
        int soldQuantity = calculateSoldQuantity(ticketType);
        return Math.max(0, ticketType.getTotalAvailable() - soldQuantity);
    }

    /**
     * Helper method to determine if a ticket type is available for purchase.
     *
     * @param ticketType the ticket type
     * @return true if available for purchase
     */
    default Boolean isTicketTypeAvailable(TicketType ticketType) {
        if (ticketType == null) {
            return false;
        }
        Integer availableQuantity = calculateAvailableQuantity(ticketType);
        return availableQuantity != null && availableQuantity > 0;
    }
} 