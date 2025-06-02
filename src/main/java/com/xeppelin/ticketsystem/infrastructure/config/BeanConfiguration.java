package com.xeppelin.ticketsystem.infrastructure.config;

import com.xeppelin.ticketsystem.application.port.output.EventRepository;
import com.xeppelin.ticketsystem.application.port.output.TicketReservationRepository;
import com.xeppelin.ticketsystem.application.port.output.TicketTypeRepository;
import com.xeppelin.ticketsystem.application.port.output.UserRepository;
import com.xeppelin.ticketsystem.domain.service.EventService;
import com.xeppelin.ticketsystem.domain.service.TicketReservationService;
import com.xeppelin.ticketsystem.domain.service.impl.EventServiceImpl;
import com.xeppelin.ticketsystem.domain.service.impl.TicketReservationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public EventService eventService(EventRepository eventRepository, UserRepository userRepository) {
        return new EventServiceImpl(userRepository, eventRepository);
    }

    @Bean
    public TicketReservationService ticketReservationService(TicketReservationRepository ticketReservationRepository,
                                                             TicketTypeRepository ticketTypeRepository,
                                                             EventRepository eventRepository, UserRepository userRepository,
                                                             TicketReservationProperties reservationProperties) {
        return new TicketReservationServiceImpl(ticketReservationRepository, ticketTypeRepository, eventRepository, userRepository, reservationProperties);
    }
}
