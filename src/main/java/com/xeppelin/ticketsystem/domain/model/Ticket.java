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
public class Ticket {

    private UUID id;

    private TicketStatusEnum status;
    
    private ZonedDateTime purchaseDate;
    
    private ZonedDateTime validUntil;
    
    private ZonedDateTime expirationDate;

    private TicketType ticketType;

    private User purchaser;

    private List<TicketValidation> validations;

    private List<QrCode> qrCodes;
} 