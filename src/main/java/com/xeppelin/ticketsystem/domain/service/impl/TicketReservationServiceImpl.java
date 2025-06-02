package com.xeppelin.ticketsystem.domain.service.impl;

import com.xeppelin.ticketsystem.application.port.output.EventRepository;
import com.xeppelin.ticketsystem.application.port.output.TicketReservationRepository;
import com.xeppelin.ticketsystem.application.port.output.TicketTypeRepository;
import com.xeppelin.ticketsystem.application.port.output.UserRepository;
import com.xeppelin.ticketsystem.domain.exception.NotFoundException;
import com.xeppelin.ticketsystem.domain.exception.InsufficientTicketsException;
import com.xeppelin.ticketsystem.domain.exception.ReservationExpiredException;
import com.xeppelin.ticketsystem.domain.exception.TicketTypeNotFoundException;
import com.xeppelin.ticketsystem.domain.model.Event;
import com.xeppelin.ticketsystem.domain.model.EventStatusEnum;
import com.xeppelin.ticketsystem.domain.model.TicketReservation;
import com.xeppelin.ticketsystem.domain.model.TicketReservationStatusEnum;
import com.xeppelin.ticketsystem.domain.model.TicketType;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.domain.service.TicketReservationService;
import com.xeppelin.ticketsystem.infrastructure.config.TicketReservationProperties;
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * Implementation of TicketReservationService that provides ticket reservation management operations.
 * <p>
 * This service handles the complete lifecycle of ticket reservations following business rules
 * and hexagonal architecture principles. It manages temporary holds on tickets, expiration
 * handling, and conversion to actual ticket purchases.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
public class TicketReservationServiceImpl implements TicketReservationService {

    private final TicketReservationRepository ticketReservationRepository;

    private final TicketTypeRepository ticketTypeRepository;

    private final EventRepository eventRepository;

    private final UserRepository userRepository;
    
    private final TicketReservationProperties reservationProperties;

    @Override
    @Transactional
    public TicketReservation createReservation(UUID eventId, UUID ticketTypeId, Integer quantity,
                                               String sessionId, UUID userId, Duration reservationDuration) {
        log.debug("Creating reservation for event: {}, ticketType: {}, quantity: {}, session: {}",
            eventId, ticketTypeId, quantity, sessionId);

        // Validate input parameters
        validateCreateReservationInput(eventId, ticketTypeId, quantity, sessionId, reservationDuration);

        // Check session reservation limit
        if (hasReachedReservationLimit(sessionId)) {
            throw new IllegalArgumentException(
                String.format("Session has reached maximum reservation limit of %d", 
                    reservationProperties.getMaxReservationsPerSession()));
        }

        // Validate and get ticket type
        TicketType ticketType = ticketTypeRepository.findById(ticketTypeId)
            .orElseThrow(() -> new TicketTypeNotFoundException(
                String.format("TicketType with ID '%s' not found", ticketTypeId)));

        // Validate event exists
        Event event = eventRepository.findByIdAndStatus(eventId, EventStatusEnum.PUBLISHED)
            .orElseThrow(() -> new NotFoundException(
                String.format("Published event with ID '%s' not found", eventId)));

        // Check if enough tickets are available
        int availableTickets = getAvailableTicketCount(ticketTypeId);
        if (availableTickets < quantity) {
            throw new InsufficientTicketsException(
                String.format("Insufficient tickets available. Requested: %d, Available: %d", quantity, availableTickets));
        }

        // Get user if provided
        User user = null;
        if (userId != null) {
            user = userRepository.findById(userId).orElse(null);
        }

        // Create reservation
        ZonedDateTime now = ZonedDateTime.now();
        TicketReservation reservation = TicketReservation.builder()
            .status(TicketReservationStatusEnum.ACTIVE)
            .reservedAt(now)
            .expiresAt(now.plus(reservationDuration))
            .sessionId(sessionId)
            .quantity(quantity)
            .ticketType(ticketType)
            .user(user)
            .event(event)
            .build();

        TicketReservation savedReservation = ticketReservationRepository.save(reservation);
        log.info("Reservation created successfully with ID: {}", savedReservation.getId());

        return savedReservation;
    }

    @Override
    @Transactional
    public TicketReservation confirmReservation(UUID reservationId) {
        log.debug("Confirming reservation: {}", reservationId);

        // Find and validate reservation
        TicketReservation reservation = ticketReservationRepository.findById(reservationId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Reservation with ID '%s' not found", reservationId)));

        // Validate reservation can be confirmed
        validateReservationForConfirmation(reservation);

        // Update reservation status
        reservation.setStatus(TicketReservationStatusEnum.CONFIRMED);
        reservation.setConfirmedAt(ZonedDateTime.now());

        TicketReservation confirmedReservation = ticketReservationRepository.save(reservation);
        log.info("Reservation {} confirmed successfully", reservationId);

        return confirmedReservation;
    }

    @Override
    @Transactional
    public TicketReservation cancelReservation(UUID reservationId, String sessionId) {
        log.debug("Cancelling reservation: {} for session: {}", reservationId, sessionId);

        // Find and validate reservation
        TicketReservation reservation = ticketReservationRepository.findByIdAndSessionId(reservationId, sessionId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Reservation with ID '%s' not found for session '%s'", reservationId, sessionId)));

        // Validate reservation can be cancelled
        validateReservationForCancellation(reservation);

        // Update reservation status
        reservation.setStatus(TicketReservationStatusEnum.CANCELLED);
        reservation.setReleasedAt(ZonedDateTime.now());

        TicketReservation cancelledReservation = ticketReservationRepository.save(reservation);
        log.info("Reservation {} cancelled successfully", reservationId);

        return cancelledReservation;
    }

    @Override
    @Transactional
    public TicketReservation extendReservation(UUID reservationId, String sessionId, Duration additionalDuration) {
        log.debug("Extending reservation: {} for session: {} by: {}", reservationId, sessionId, additionalDuration);

        // Validate extension duration
        if (additionalDuration == null || additionalDuration.isNegative() || additionalDuration.isZero()) {
            throw new IllegalArgumentException("Additional duration must be positive");
        }

        if (additionalDuration.compareTo(reservationProperties.getMaxExtensionDuration()) > 0) {
            throw new IllegalArgumentException(
                String.format("Extension duration cannot exceed %d minutes", 
                    reservationProperties.getMaxExtensionDuration().toMinutes()));
        }

        // Find and validate reservation
        TicketReservation reservation = ticketReservationRepository.findByIdAndSessionId(reservationId, sessionId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Reservation with ID '%s' not found for session '%s'", reservationId, sessionId)));

        // Validate reservation can be extended
        validateReservationForExtension(reservation);

        // Extend expiration time
        reservation.setExpiresAt(reservation.getExpiresAt().plus(additionalDuration));

        TicketReservation extendedReservation = ticketReservationRepository.save(reservation);
        log.info("Reservation {} extended successfully until: {}", reservationId, extendedReservation.getExpiresAt());

        return extendedReservation;
    }

    @Override
    public Optional<TicketReservation> getReservation(UUID reservationId) {
        log.debug("Getting reservation: {}", reservationId);

        if (reservationId == null) {
            throw new IllegalArgumentException("Reservation ID cannot be null");
        }

        return ticketReservationRepository.findById(reservationId);
    }

    @Override
    public List<TicketReservation> getActiveReservationsForSession(String sessionId) {
        log.debug("Getting active reservations for session: {}", sessionId);

        validateSessionId(sessionId);

        return ticketReservationRepository.findBySessionIdAndStatus(sessionId, TicketReservationStatusEnum.ACTIVE);
    }

    @Override
    public List<TicketReservation> getActiveReservationsForTicketType(UUID ticketTypeId) {
        log.debug("Getting active reservations for ticket type: {}", ticketTypeId);

        if (ticketTypeId == null) {
            throw new IllegalArgumentException("Ticket type ID cannot be null");
        }

        return ticketReservationRepository.findByTicketTypeIdAndStatus(ticketTypeId, TicketReservationStatusEnum.ACTIVE);
    }

    @Override
    @Transactional
    public int processExpiredReservations() {
        log.debug("Processing expired reservations");

        ZonedDateTime now = ZonedDateTime.now();
        List<TicketReservation> expiredReservations = ticketReservationRepository.findExpiredActiveReservations(now);

        if (expiredReservations.isEmpty()) {
            log.debug("No expired reservations found");
            return 0;
        }

        List<UUID> expiredIds = expiredReservations.stream()
            .map(TicketReservation::getId)
            .collect(Collectors.toList());

        int updatedCount = ticketReservationRepository.markReservationsAsExpired(expiredIds, now);
        log.info("Processed {} expired reservations", updatedCount);

        return updatedCount;
    }

    @Override
    public int getAvailableTicketCount(UUID ticketTypeId) {
        log.debug("Calculating available tickets for ticket type: {}", ticketTypeId);

        if (ticketTypeId == null) {
            throw new IllegalArgumentException("Ticket type ID cannot be null");
        }

        // Get ticket type to know total available
        TicketType ticketType = ticketTypeRepository.findById(ticketTypeId)
            .orElseThrow(() -> new TicketTypeNotFoundException(
                String.format("TicketType with ID '%s' not found", ticketTypeId)));

        // Get currently reserved quantity
        Integer reservedQuantity = ticketReservationRepository.sumActiveReservationQuantityByTicketType(ticketTypeId);

        int available = ticketType.getTotalAvailable() - (reservedQuantity != null ? reservedQuantity : 0);
        return Math.max(0, available); // Ensure non-negative result
    }

    @Override
    public boolean hasReachedReservationLimit(String sessionId) {
        if (!StringUtils.hasText(sessionId)) {
            return true; // Invalid session always considered at limit
        }

        long activeCount = ticketReservationRepository.countActiveReservationsBySession(sessionId);
        return activeCount >= reservationProperties.getMaxReservationsPerSession();
    }

    // Private validation methods

    private void validateCreateReservationInput(UUID eventId, UUID ticketTypeId, Integer quantity,
                                                String sessionId, Duration reservationDuration) {
        if (eventId == null) {
            throw new IllegalArgumentException("Event ID cannot be null");
        }

        if (ticketTypeId == null) {
            throw new IllegalArgumentException("Ticket type ID cannot be null");
        }

        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (quantity > reservationProperties.getMaxQuantityPerReservation()) {
            throw new IllegalArgumentException(
                String.format("Quantity cannot exceed %d per reservation", 
                    reservationProperties.getMaxQuantityPerReservation()));
        }

        validateSessionId(sessionId);

        if (reservationDuration == null || reservationDuration.isNegative() || reservationDuration.isZero()) {
            throw new IllegalArgumentException("Reservation duration must be positive");
        }
    }

    private void validateSessionId(String sessionId) {
        if (!StringUtils.hasText(sessionId)) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
    }

    private void validateReservationForConfirmation(TicketReservation reservation) {
        if (reservation.getStatus() != TicketReservationStatusEnum.ACTIVE) {
            throw new IllegalStateException(
                String.format("Reservation is not in ACTIVE status. Current status: %s", reservation.getStatus()));
        }

        if (reservation.getExpiresAt().isBefore(ZonedDateTime.now())) {
            throw new ReservationExpiredException(
                String.format("Reservation expired at: %s", reservation.getExpiresAt()));
        }
    }

    private void validateReservationForCancellation(TicketReservation reservation) {
        if (reservation.getStatus() != TicketReservationStatusEnum.ACTIVE) {
            throw new IllegalStateException(
                String.format("Cannot cancel reservation with status: %s", reservation.getStatus()));
        }
    }

    private void validateReservationForExtension(TicketReservation reservation) {
        if (reservation.getStatus() != TicketReservationStatusEnum.ACTIVE) {
            throw new IllegalStateException(
                String.format("Cannot extend reservation with status: %s", reservation.getStatus()));
        }

        if (reservation.getExpiresAt().isBefore(ZonedDateTime.now())) {
            throw new ReservationExpiredException(
                String.format("Cannot extend expired reservation. Expired at: %s", reservation.getExpiresAt()));
        }
    }
}
