package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository;

import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketTypeEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeJpaRepository extends JpaRepository<TicketTypeEntity, UUID> {

    List<TicketTypeEntity> findByEventId(UUID eventId);

    @Query("SELECT tt FROM TicketTypeEntity tt WHERE tt.event.id = :eventId AND tt.totalAvailable > 0")
    List<TicketTypeEntity> findAvailableTicketTypesByEventId(@Param("eventId") UUID eventId);
} 