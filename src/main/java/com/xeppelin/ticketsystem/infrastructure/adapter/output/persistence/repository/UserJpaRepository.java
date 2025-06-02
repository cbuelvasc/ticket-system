package com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.repository;

import com.xeppelin.ticketsystem.infrastructure.adapter.output.persistence.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

}
