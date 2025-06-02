package com.xeppelin.ticketsystem.domain.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private UUID id;

    private String name;

    private ZonedDateTime start;

    private ZonedDateTime end;

    private String venue;

    private ZonedDateTime salesStart;

    private ZonedDateTime salesEnd;

    private EventStatusEnum status;

    private User organizer;

    private List<User> attendees;

    private List<User> staff;

    private List<TicketType> ticketTypes;
}
