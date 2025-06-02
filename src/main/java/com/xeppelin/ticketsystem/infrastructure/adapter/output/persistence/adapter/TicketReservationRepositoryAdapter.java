package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.adapter;

import com.xeppelin.ticketsystem.application.port.output.TicketReservationRepository;
import com.xeppelin.ticketsystem.domain.model.TicketReservation;
import com.xeppelin.ticketsystem.domain.model.TicketReservationStatusEnum;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketReservationEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper.TicketReservationMapper;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository.TicketReservationJpaRepository;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter that implements the TicketReservationRepository output port using JPA repository.
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
public class TicketReservationRepositoryAdapter implements TicketReservationRepository {

    private final TicketReservationJpaRepository ticketReservationRepository;

    private final TicketReservationMapper mapper;

    @Override
    public TicketReservation save(TicketReservation reservation) {
        TicketReservationEntity entity = mapper.fromTicketReservationToTicketReservationEntity(reservation);
        TicketReservationEntity savedEntity = ticketReservationRepository.save(entity);
        return mapper.fromTicketReservationEntityToTicketReservation(savedEntity);
    }

    @Override
    public Optional<TicketReservation> findById(UUID reservationId) {
        Optional<TicketReservationEntity> entity = ticketReservationRepository.findById(reservationId);
        return entity.map(mapper::fromTicketReservationEntityToTicketReservation);
    }

    @Override
    public List<TicketReservation> findBySessionIdAndStatus(String sessionId, TicketReservationStatusEnum status) {
        List<TicketReservationEntity> entities = ticketReservationRepository.findBySessionIdAndStatus(sessionId, status);
        return entities.stream()
            .map(mapper::fromTicketReservationEntityToTicketReservation)
            .collect(Collectors.toList());
    }

    @Override
    public List<TicketReservation> findByTicketTypeIdAndStatus(UUID ticketTypeId, TicketReservationStatusEnum status) {
        List<TicketReservationEntity> entities = ticketReservationRepository.findByTicketTypeIdAndStatus(ticketTypeId, status);
        return entities.stream()
            .map(mapper::fromTicketReservationEntityToTicketReservation)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<TicketReservation> findByIdAndSessionId(UUID reservationId, String sessionId) {
        Optional<TicketReservationEntity> entity = ticketReservationRepository.findByIdAndSessionId(reservationId, sessionId);
        return entity.map(mapper::fromTicketReservationEntityToTicketReservation);
    }

    @Override
    public List<TicketReservation> findExpiredActiveReservations(ZonedDateTime currentTime) {
        List<TicketReservationEntity> entities = ticketReservationRepository.findExpiredActiveReservations(currentTime);
        return entities.stream()
            .map(mapper::fromTicketReservationEntityToTicketReservation)
            .collect(Collectors.toList());
    }

    @Override
    public long countActiveReservationsBySession(String sessionId) {
        return ticketReservationRepository.countActiveReservationsBySession(sessionId);
    }

    @Override
    public Integer sumActiveReservationQuantityByTicketType(UUID ticketTypeId) {
        Integer result = ticketReservationRepository.sumActiveReservationQuantityByTicketType(ticketTypeId);
        return result != null ? result : 0;
    }

    @Override
    public boolean existsBySessionIdAndTicketTypeIdAndStatus(String sessionId, UUID ticketTypeId, TicketReservationStatusEnum status) {
        return ticketReservationRepository.existsBySessionIdAndTicketTypeIdAndStatus(sessionId, ticketTypeId, status);
    }

    @Override
    public int markReservationsAsExpired(List<UUID> reservationIds, ZonedDateTime releasedAt) {
        return ticketReservationRepository.markReservationsAsExpired(reservationIds, releasedAt);
    }

    @Override
    public void delete(TicketReservation reservation) {
        TicketReservationEntity entity = mapper.fromTicketReservationToTicketReservationEntity(reservation);
        ticketReservationRepository.delete(entity);
    }
}
