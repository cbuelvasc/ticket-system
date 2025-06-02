package com.xeppelin.ticketsystem.domain.model;

import java.time.ZonedDateTime;
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
public class TicketReservation {

    private UUID id;

    private TicketReservationStatusEnum status;

    private ZonedDateTime reservedAt;

    private ZonedDateTime expiresAt;

    private ZonedDateTime confirmedAt;

    private ZonedDateTime releasedAt;

    private String sessionId;

    private Integer quantity;

    private TicketType ticketType;

    private User user;

    private Event event;
} 