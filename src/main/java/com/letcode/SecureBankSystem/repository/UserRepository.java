package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.status = :status")
    List<UserEntity> searchUsers(@Param("status") Status status);
}

