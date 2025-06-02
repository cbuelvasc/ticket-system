package com.xeppelin.ticketsystem.application.port.output;

import com.xeppelin.ticketsystem.domain.model.TicketType;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for TicketType repository operations.
 * <p>
 * This interface defines the contract for ticket type data access operations
 * following the hexagonal architecture pattern.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface TicketTypeRepository {

    /**
     * Finds a ticket type by ID.
     *
     * @param ticketTypeId the ticket type's unique identifier
     * @return optional containing the ticket type if found
     * @throws IllegalArgumentException if ticketTypeId is null
     */
    Optional<TicketType> findById(UUID ticketTypeId);

    /**
     * Saves a ticket type.
     *
     * @param ticketType the ticket type to save
     * @return the saved ticket type
     * @throws IllegalArgumentException if ticketType is null
     */
    TicketType save(TicketType ticketType);
} 