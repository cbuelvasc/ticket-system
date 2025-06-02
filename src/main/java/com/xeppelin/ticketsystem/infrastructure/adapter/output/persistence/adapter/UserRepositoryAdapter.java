package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.adapter;

import com.xeppelin.ticketsystem.application.port.output.UserRepository;
import com.xeppelin.ticketsystem.domain.model.User;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.UserEntity;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.mapper.UserMapper;
import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository.UserJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter that implements the UserRepository output port using JPA repository.
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
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public Optional<User> findById(UUID userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.map(userMapper::fromUserEntityToUser);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.fromUserToUserEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.fromUserEntityToUser(savedEntity);
    }
} 