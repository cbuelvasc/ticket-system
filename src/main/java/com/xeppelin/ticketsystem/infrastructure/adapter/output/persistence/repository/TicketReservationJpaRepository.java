package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository;

import com.xeppelin.ticketsystem.domain.model.TicketReservationStatusEnum;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.TicketReservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketReservationJpaRepository extends JpaRepository<TicketReservationEntity, UUID> {

    List<TicketReservationEntity> findBySessionIdAndStatus(String sessionId, TicketReservationStatusEnum status);

    List<TicketReservationEntity> findByTicketTypeIdAndStatus(UUID ticketTypeId, TicketReservationStatusEnum status);

    Optional<TicketReservationEntity> findByIdAndSessionId(UUID id, String sessionId);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.status = 'ACTIVE' AND tr.expiresAt < :currentTime")
    List<TicketReservationEntity> findExpiredActiveReservations(@Param("currentTime") ZonedDateTime currentTime);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.status = 'ACTIVE' AND tr.expiresAt < :currentTime")
    Page<TicketReservationEntity> findExpiredActiveReservations(@Param("currentTime") ZonedDateTime currentTime, Pageable pageable);

    @Query("SELECT COUNT(tr) FROM TicketReservationEntity tr WHERE tr.sessionId = :sessionId AND tr.status = 'ACTIVE'")
    long countActiveReservationsBySession(@Param("sessionId") String sessionId);

    @Query("SELECT COALESCE(SUM(tr.quantity), 0) FROM TicketReservationEntity tr " +
           "WHERE tr.ticketType.id = :ticketTypeId AND tr.status = 'ACTIVE'")
    Integer sumActiveReservationQuantityByTicketType(@Param("ticketTypeId") UUID ticketTypeId);

    List<TicketReservationEntity> findByEventIdOrderByReservedAtDesc(UUID eventId);
    
    Page<TicketReservationEntity> findByEventIdOrderByReservedAtDesc(UUID eventId, Pageable pageable);

    List<TicketReservationEntity> findByUserIdOrderByReservedAtDesc(UUID userId);
    
    Page<TicketReservationEntity> findByUserIdOrderByReservedAtDesc(UUID userId, Pageable pageable);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.status = 'ACTIVE' " +
           "AND tr.expiresAt BETWEEN :startTime AND :endTime")
    List<TicketReservationEntity> findReservationsExpiringBetween(
            @Param("startTime") ZonedDateTime startTime, 
            @Param("endTime") ZonedDateTime endTime);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.status = 'ACTIVE' " +
           "AND tr.expiresAt BETWEEN :startTime AND :endTime")
    Page<TicketReservationEntity> findReservationsExpiringBetween(
            @Param("startTime") ZonedDateTime startTime, 
            @Param("endTime") ZonedDateTime endTime, 
            Pageable pageable);

    @Modifying
    @Query("UPDATE TicketReservationEntity tr SET tr.status = 'EXPIRED', tr.releasedAt = :releasedAt " +
           "WHERE tr.id IN :reservationIds")
    int markReservationsAsExpired(@Param("reservationIds") List<UUID> reservationIds, 
                                 @Param("releasedAt") ZonedDateTime releasedAt);

    List<TicketReservationEntity> findByStatusInOrderByReservedAtDesc(List<TicketReservationStatusEnum> statuses);
    
    Page<TicketReservationEntity> findByStatusInOrderByReservedAtDesc(List<TicketReservationStatusEnum> statuses, Pageable pageable);

    boolean existsBySessionIdAndTicketTypeIdAndStatus(String sessionId, UUID ticketTypeId, TicketReservationStatusEnum status);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.reservedAt BETWEEN :startDate AND :endDate " +
           "ORDER BY tr.reservedAt DESC")
    List<TicketReservationEntity> findReservationsByDateRange(
            @Param("startDate") ZonedDateTime startDate, 
            @Param("endDate") ZonedDateTime endDate);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.reservedAt BETWEEN :startDate AND :endDate " +
           "ORDER BY tr.reservedAt DESC")
    Page<TicketReservationEntity> findReservationsByDateRange(
            @Param("startDate") ZonedDateTime startDate, 
            @Param("endDate") ZonedDateTime endDate, 
            Pageable pageable);

    Page<TicketReservationEntity> findByStatusOrderByReservedAtDesc(TicketReservationStatusEnum status, Pageable pageable);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.event.id = :eventId AND tr.status IN :statuses " +
           "ORDER BY tr.reservedAt DESC")
    Page<TicketReservationEntity> findByEventIdAndStatusInOrderByReservedAtDesc(
            @Param("eventId") UUID eventId, 
            @Param("statuses") List<TicketReservationStatusEnum> statuses, 
            Pageable pageable);

    @Query("SELECT tr FROM TicketReservationEntity tr WHERE tr.user.id = :userId AND tr.status IN :statuses " +
           "ORDER BY tr.reservedAt DESC")
    Page<TicketReservationEntity> findByUserIdAndStatusInOrderByReservedAtDesc(
            @Param("userId") UUID userId, 
            @Param("statuses") List<TicketReservationStatusEnum> statuses, 
            Pageable pageable);
} 