package com.xeppelin.ticketsystem.application.port.output;

import com.xeppelin.ticketsystem.domain.model.User;
import java.util.Optional;
import java.util.UUID;

/**
 * Output port for User repository operations.
 * <p>
 * This interface defines the contract for user data access operations
 * following the hexagonal architecture pattern.
 * </p>
 *
 * @author Xeppelin Team
 * @version 1.0
 * @since 1.0
 */
public interface UserRepository {

    /**
     * Finds a user by ID.
     *
     * @param userId the user's unique identifier
     * @return optional containing the user if found
     * @throws IllegalArgumentException if userId is null
     */
    Optional<User> findById(UUID userId);

    /**
     * Saves a user.
     *
     * @param user the user to save
     * @return the saved user
     * @throws IllegalArgumentException if user is null
     */
    User save(User user);
} 