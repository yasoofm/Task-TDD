package com.letcode.SecureBankSystem.repositories;

import com.letcode.SecureBankSystem.entities.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

}
