package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository;

import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.EventEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJpaRepository extends JpaRepository<EventEntity, UUID> {

    Page<EventEntity> findByOrganizerId(UUID organizerId, Pageable pageable);

    Optional<EventEntity> findByIdAndOrganizerId(UUID id, UUID organizerId);

    Page<EventEntity> findByStatus(EventStatusEnum status, Pageable pageable);

    @Query("SELECT e FROM EventEntity e WHERE " +
        "e.status = com.xeppelin.ticketsystem.domain.model.EventStatusEnum.PUBLISHED AND " +
        "(LOWER(e.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
        "LOWER(e.venue) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    Page<EventEntity> searchEvents(@Param("searchTerm") String searchTerm, Pageable pageable);

    Optional<EventEntity> findByIdAndStatus(UUID id, EventStatusEnum status);
}
