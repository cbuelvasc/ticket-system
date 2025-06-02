package com.xeppelin.ticketsystem.domain.model;

/**
 * Enumeration of possible ticket reservation statuses.
 * 
 * This enum tracks the lifecycle of temporary ticket reservations:
 * - ACTIVE: Reservation is active and holding tickets
 * - CONFIRMED: Reservation was converted to actual ticket purchase
 * - EXPIRED: Reservation expired due to timeout
 * - CANCELLED: Reservation was manually cancelled by user
 * - RELEASED: Reservation was released due to system action
 */
public enum TicketReservationStatusEnum {
    
    /**
     * Reservation is currently active and holding tickets.
     * Tickets cannot be reserved by others until this expires or is confirmed.
     */
    ACTIVE,
    
    /**
     * Reservation was successfully confirmed and converted to ticket purchase.
     * This is the successful end state of a reservation.
     */
    CONFIRMED,
    
    /**
     * Reservation expired due to timeout.
     * Tickets are now available for other users to reserve.
     */
    EXPIRED,
    
    /**
     * Reservation was manually cancelled by the user.
     * Tickets are immediately available for other users.
     */
    CANCELLED,
    
    /**
     * Reservation was released due to system action (e.g., admin action, system maintenance).
     * Tickets are immediately available for other users.
     */
    RELEASED
} 