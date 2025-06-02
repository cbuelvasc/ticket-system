package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper;

import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.EventEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "organizedEvents", qualifiedByName = "mapEventsWithoutUsers")
    @Mapping(target = "attendingEvents", qualifiedByName = "mapEventsWithoutUsers")
    @Mapping(target = "staffingEvents", qualifiedByName = "mapEventsWithoutUsers")
    UserEntity fromUserToUserEntity(User user);

    @Mapping(target = "organizedEvents", qualifiedByName = "mapEventEntitiesWithoutUsers")
    @Mapping(target = "attendingEvents", qualifiedByName = "mapEventEntitiesWithoutUsers")
    @Mapping(target = "staffingEvents", qualifiedByName = "mapEventEntitiesWithoutUsers")
    User fromUserEntityToUser(UserEntity userEntity);

    @Named("mapEventsWithoutUsers")
    default List<EventEntity> mapEventsWithoutUsers(List<Event> events) {
        if (events == null) {
            return null;
        }
        return events.stream()
                .map(this::mapEventWithoutUsers)
                .collect(Collectors.toList());
    }

    @Named("mapEventEntitiesWithoutUsers")
    default List<Event> mapEventEntitiesWithoutUsers(List<EventEntity> eventEntities) {
        if (eventEntities == null) {
            return null;
        }
        return eventEntities.stream()
                .map(this::mapEventEntityWithoutUsers)
                .collect(Collectors.toList());
    }

    @Named("mapEventWithoutUsers")
    @Mapping(target = "organizer", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "ticketTypes", ignore = true)
    EventEntity mapEventWithoutUsers(Event event);

    @Named("mapEventEntityWithoutUsers")
    @Mapping(target = "organizer", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "ticketTypes", ignore = true)
    Event mapEventEntityWithoutUsers(EventEntity eventEntity);
} 