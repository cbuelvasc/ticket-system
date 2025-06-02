package com.xeppelin.ticketsystem.infrastructure.config;

import com.xeppelin.ticketsystem.domain.service.TicketReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * Scheduled task for cleaning up expired ticket reservations.
 * <p>
 * This task runs periodically to:
 * </p>
 * <ul>
 *   <li>Find reservations that have expired based on their expiresAt timestamp</li>
 *   <li>Mark them as EXPIRED status</li>
 *   <li>Free up the reserved tickets for other users</li>
 *   <li>Log cleanup statistics for monitoring</li>
 * </ul>
 * <p>
 * The cleanup process ensures that expired reservations are handled efficiently
 * and tickets become available for new reservations without significant delay.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationCleanupTask {

    private final TicketReservationService ticketReservationService;

    /**
     * Processes expired reservations every 2 minutes.
     * <p>
     * This frequent execution ensures that expired reservations are cleaned up
     * quickly, making tickets available for other users without significant delay.
     * The fixedDelay ensures there's a 2-minute gap between the end of one
     * execution and the start of the next, preventing overlapping executions.
     * </p>
     * 
     * @throws Exception if there's an error during the cleanup process
     */
    @Scheduled(fixedDelay = 120000) // 2 minutes in milliseconds
    public void cleanupExpiredReservations() {
        ZonedDateTime startTime = ZonedDateTime.now();
        
        try {
            log.debug("Starting cleanup of expired reservations at {}", startTime);
            
            int expiredCount = ticketReservationService.processExpiredReservations();
            
            ZonedDateTime endTime = ZonedDateTime.now();
            long durationMs = java.time.Duration.between(startTime, endTime).toMillis();
            
            if (expiredCount > 0) {
                log.info("Cleanup completed: {} reservations expired in {}ms at {}", 
                        expiredCount, durationMs, endTime);
            } else {
                log.debug("Cleanup completed: no expired reservations found in {}ms at {}", 
                         durationMs, endTime);
            }
            
        } catch (Exception e) {
            ZonedDateTime errorTime = ZonedDateTime.now();
            long durationMs = java.time.Duration.between(startTime, errorTime).toMillis();
            
            log.error("Error during reservation cleanup after {}ms at {}: {}", 
                     durationMs, errorTime, e.getMessage(), e);
        }
    }

    /**
     * Logs reservation statistics every 30 minutes for monitoring.
     * <p>
     * This provides insights into reservation patterns and system health.
     * The statistics help monitor the overall performance and usage patterns
     * of the reservation system.
     * </p>
     * 
     * @throws Exception if there's an error during statistics logging
     */
    @Scheduled(fixedDelay = 1800000) // 30 minutes in milliseconds
    public void logReservationStatistics() {
        ZonedDateTime currentTime = ZonedDateTime.now();
        
        try {
            // This could call additional methods to gather statistics
            log.info("Reservation statistics logged at {}", currentTime);
            
        } catch (Exception e) {
            log.error("Error logging reservation statistics at {}: {}", 
                     currentTime, e.getMessage(), e);
        }
    }
} 