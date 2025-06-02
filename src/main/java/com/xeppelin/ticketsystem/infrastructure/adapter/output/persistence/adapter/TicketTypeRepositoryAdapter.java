package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.adapter;

import com.xeppelin.ticketsystem.application.port.output.TicketTypeRepository;
import com.xeppelin.ticketsystem.domain.model.TicketType;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketTypeEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper.TicketTypeMapper;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository.TicketTypeJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter that implements the TicketTypeRepository output port using JPA repository.
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
public class TicketTypeRepositoryAdapter implements TicketTypeRepository {

    private final TicketTypeJpaRepository ticketTypeRepository;

    private final TicketTypeMapper mapper;

    @Override
    public Optional<TicketType> findById(UUID ticketTypeId) {
        Optional<TicketTypeEntity> entity = ticketTypeRepository.findById(ticketTypeId);
        return entity.map(mapper::fromTicketTypeEntityToTicketType);
    }

    @Override
    public TicketType save(TicketType ticketType) {
        TicketTypeEntity entity = mapper.fromTicketTypeToTicketTypeEntity(ticketType);
        TicketTypeEntity savedEntity = ticketTypeRepository.save(entity);
        return mapper.fromTicketTypeEntityToTicketType(savedEntity);
    }
} 