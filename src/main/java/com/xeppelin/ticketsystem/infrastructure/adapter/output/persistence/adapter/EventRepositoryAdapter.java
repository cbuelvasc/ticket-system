package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.adapter;

import com.xeppelin.ticketsystem.application.port.output.EventRepository;
import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.EventEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper.EventMapper;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository.EventJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Adapter that implements the EventRepository output port using JPA repository.
 * <p>
 * This adapter bridges the domain layer with the infrastructure persistence layer,
 * converting between domain objects and JPA entities using mappers.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class EventRepositoryAdapter implements EventRepository {

    private final EventJpaRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public Event save(Event event) {
        EventEntity eventEntity = eventMapper.fromEventToEventEntity(event);
        EventEntity savedEntity = eventRepository.save(eventEntity);
        return eventMapper.fromEventEntityToEvent(savedEntity);
    }

    @Override
    public Page<Event> findByOrganizerId(UUID organizerId, Pageable pageable) {
        Page<EventEntity> eventEntities = eventRepository.findByOrganizerId(organizerId, pageable);
        return eventEntities.map(eventMapper::fromEventEntityToEvent);
    }

    @Override
    public Optional<Event> findByIdAndOrganizerId(UUID eventId, UUID organizerId) {
        Optional<EventEntity> eventEntity = eventRepository.findByIdAndOrganizerId(eventId, organizerId);
        return eventEntity.map(eventMapper::fromEventEntityToEvent);
    }

    @Override
    public Page<Event> findByStatus(EventStatusEnum status, Pageable pageable) {
        Page<EventEntity> eventEntities = eventRepository.findByStatus(status, pageable);
        return eventEntities.map(eventMapper::fromEventEntityToEvent);
    }

    @Override
    public Page<Event> searchEvents(String searchTerm, Pageable pageable) {
        Page<EventEntity> eventEntities = eventRepository.searchEvents(searchTerm, pageable);
        return eventEntities.map(eventMapper::fromEventEntityToEvent);
    }

    @Override
    public Optional<Event> findByIdAndStatus(UUID eventId, EventStatusEnum status) {
        Optional<EventEntity> eventEntity = eventRepository.findByIdAndStatus(eventId, status);
        return eventEntity.map(eventMapper::fromEventEntityToEvent);
    }

    @Override
    public void delete(Event event) {
        EventEntity eventEntity = eventMapper.fromEventToEventEntity(event);
        eventRepository.delete(eventEntity);
    }
}
