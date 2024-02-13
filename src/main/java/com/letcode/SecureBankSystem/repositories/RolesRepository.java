package com.letcode.SecureBankSystem.repositories;

import com.letcode.SecureBankSystem.entities.RolesEntity;
import com.letcode.SecureBankSystem.utils.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    @Query(value = "SELECT * FROM role r where r.title = :title",nativeQuery = true)
    Optional<RolesEntity> findRoleEntityByTitle(String title);
}
