package com.letcode.SecureBankSystem.repositories;

import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.status = :status")
    List<UserEntity> searchUsers(@Param("status") Status status);

    Optional<UserEntity> findByUsername(String username);

}

