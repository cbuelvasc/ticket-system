package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper;

import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.TicketType;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.EventEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketTypeEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    @Mapping(target = "organizer", qualifiedByName = "mapUserWithoutEvents")
    @Mapping(target = "attendees", qualifiedByName = "mapUsersWithoutEvents")
    @Mapping(target = "staff", qualifiedByName = "mapUsersWithoutEvents")
    @Mapping(target = "ticketTypes", qualifiedByName = "mapTicketTypesWithoutEvent")
    EventEntity fromEventToEventEntity(Event event);

    @AfterMapping
    default void setEventReferenceInTicketTypes(@MappingTarget EventEntity eventEntity) {
        if (eventEntity.getTicketTypes() != null) {
            eventEntity.getTicketTypes().forEach(ticketType -> ticketType.setEvent(eventEntity));
        }
    }

    @Mapping(target = "organizer", qualifiedByName = "mapUserEntityWithoutEvents")
    @Mapping(target = "attendees", qualifiedByName = "mapUserEntitiesWithoutEvents")
    @Mapping(target = "staff", qualifiedByName = "mapUserEntitiesWithoutEvents")
    @Mapping(target = "ticketTypes", qualifiedByName = "mapTicketTypeEntitiesWithoutEvent")
    Event fromEventEntityToEvent(EventEntity eventEntity);

    @AfterMapping
    default void setEventReferenceInTicketTypesDomain(@MappingTarget Event event) {
        if (event.getTicketTypes() != null) {
            event.getTicketTypes().forEach(ticketType -> ticketType.setEvent(event));
        }
    }

    @Named("mapUserWithoutEvents")
    @Mapping(target = "organizedEvents", ignore = true)
    @Mapping(target = "attendingEvents", ignore = true)
    @Mapping(target = "staffingEvents", ignore = true)
    UserEntity mapUserWithoutEvents(User user);

    @Named("mapUserEntityWithoutEvents")
    @Mapping(target = "organizedEvents", ignore = true)
    @Mapping(target = "attendingEvents", ignore = true)
    @Mapping(target = "staffingEvents", ignore = true)
    User mapUserEntityWithoutEvents(UserEntity userEntity);

    @Named("mapUsersWithoutEvents")
    default List<UserEntity> mapUsersWithoutEvents(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(this::mapUserWithoutEvents)
                .collect(Collectors.toList());
    }

    @Named("mapUserEntitiesWithoutEvents")
    default List<User> mapUserEntitiesWithoutEvents(List<UserEntity> userEntities) {
        if (userEntities == null) {
            return null;
        }
        return userEntities.stream()
                .map(this::mapUserEntityWithoutEvents)
                .collect(Collectors.toList());
    }

    @Named("mapTicketTypesWithoutEvent")
    default List<TicketTypeEntity> mapTicketTypesWithoutEvent(List<TicketType> ticketTypes) {
        if (ticketTypes == null) {
            return null;
        }
        return ticketTypes.stream()
                .map(this::mapTicketTypeWithoutEvent)
                .collect(Collectors.toList());
    }

    @Named("mapTicketTypeEntitiesWithoutEvent")
    default List<TicketType> mapTicketTypeEntitiesWithoutEvent(List<TicketTypeEntity> ticketTypeEntities) {
        if (ticketTypeEntities == null) {
            return null;
        }
        return ticketTypeEntities.stream()
                .map(this::mapTicketTypeEntityWithoutEvent)
                .collect(Collectors.toList());
    }

    @Named("mapTicketTypeWithoutEvent")
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    TicketTypeEntity mapTicketTypeWithoutEvent(TicketType ticketType);

    @Named("mapTicketTypeEntityWithoutEvent")
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    TicketType mapTicketTypeEntityWithoutEvent(TicketTypeEntity ticketTypeEntity);
}
