package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper;

import com.xeppelin.ticketsystem.domain.model.TicketType;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketTypeMapper {

    @Mapping(target = "event.organizer.organizedEvents", ignore = true)
    @Mapping(target = "event.organizer.attendingEvents", ignore = true)
    @Mapping(target = "event.organizer.staffingEvents", ignore = true)
    @Mapping(target = "event.attendees", ignore = true)
    @Mapping(target = "event.staff", ignore = true)
    @Mapping(target = "event.ticketTypes", ignore = true)
    @Mapping(target = "tickets.ticketType", ignore = true)
    @Mapping(target = "tickets.purchaser.organizedEvents", ignore = true)
    @Mapping(target = "tickets.purchaser.attendingEvents", ignore = true)
    @Mapping(target = "tickets.purchaser.staffingEvents", ignore = true)
    @Mapping(target = "tickets.validations", ignore = true)
    @Mapping(target = "tickets.qrCodes", ignore = true)
    TicketTypeEntity fromTicketTypeToTicketTypeEntity(TicketType ticketType);

    @Mapping(target = "event.organizer.organizedEvents", ignore = true)
    @Mapping(target = "event.organizer.attendingEvents", ignore = true)
    @Mapping(target = "event.organizer.staffingEvents", ignore = true)
    @Mapping(target = "event.attendees", ignore = true)
    @Mapping(target = "event.staff", ignore = true)
    @Mapping(target = "event.ticketTypes", ignore = true)
    @Mapping(target = "tickets.ticketType", ignore = true)
    @Mapping(target = "tickets.purchaser.organizedEvents", ignore = true)
    @Mapping(target = "tickets.purchaser.attendingEvents", ignore = true)
    @Mapping(target = "tickets.purchaser.staffingEvents", ignore = true)
    @Mapping(target = "tickets.validations", ignore = true)
    @Mapping(target = "tickets.qrCodes", ignore = true)
    TicketType fromTicketTypeEntityToTicketType(TicketTypeEntity ticketTypeEntity);
} 