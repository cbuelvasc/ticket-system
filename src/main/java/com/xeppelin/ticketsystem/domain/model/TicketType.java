package com.xeppelin.ticketsystem.domain.model;

import java.math.BigDecimal;
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
public class TicketType {

    private UUID id;

    private String name;

    private BigDecimal price;

    private String description;

    private Integer totalAvailable;

    private Event event;

    private List<Ticket> tickets;
} 