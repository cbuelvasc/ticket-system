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
public class TicketValidation {

    private UUID id;

    private TicketValidationStatusEnum status;

    private TicketValidationMethodEnum validationMethod;

    private ZonedDateTime validationDateTime;
    
    private String validationLocation;

    private Ticket ticket;
} 