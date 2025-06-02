package com.xeppelin.ticketsystem.domain.model;

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
public class User {

    private UUID id;

    private String name;

    private String email;

    private List<Event> organizedEvents;

    private List<Event> attendingEvents;

    private List<Event> staffingEvents;
} 