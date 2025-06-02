package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper;

import com.xeppelin.ticketsystem.domain.model.TicketReservation;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketReservationMapper {

    @Mapping(target = "ticketType.event", ignore = true)
    @Mapping(target = "ticketType.tickets", ignore = true)
    @Mapping(target = "user.organizedEvents", ignore = true)
    @Mapping(target = "user.attendingEvents", ignore = true)
    @Mapping(target = "user.staffingEvents", ignore = true)
    @Mapping(target = "event.organizer.organizedEvents", ignore = true)
    @Mapping(target = "event.organizer.attendingEvents", ignore = true)
    @Mapping(target = "event.organizer.staffingEvents", ignore = true)
    @Mapping(target = "event.attendees", ignore = true)
    @Mapping(target = "event.staff", ignore = true)
    @Mapping(target = "event.ticketTypes", ignore = true)
    TicketReservationEntity fromTicketReservationToTicketReservationEntity(TicketReservation ticketReservation);

    @Mapping(target = "ticketType.event", ignore = true)
    @Mapping(target = "ticketType.tickets", ignore = true)
    @Mapping(target = "user.organizedEvents", ignore = true)
    @Mapping(target = "user.attendingEvents", ignore = true)
    @Mapping(target = "user.staffingEvents", ignore = true)
    @Mapping(target = "event.organizer.organizedEvents", ignore = true)
    @Mapping(target = "event.organizer.attendingEvents", ignore = true)
    @Mapping(target = "event.organizer.staffingEvents", ignore = true)
    @Mapping(target = "event.attendees", ignore = true)
    @Mapping(target = "event.staff", ignore = true)
    @Mapping(target = "event.ticketTypes", ignore = true)
    TicketReservation fromTicketReservationEntityToTicketReservation(TicketReservationEntity ticketReservationEntity);
} 