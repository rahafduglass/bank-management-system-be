package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.enums.CardStatus;
import com.bank.backend.persistance.entity.CardEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CardJpaRepository extends JpaRepository<CardEntity,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE card c SET c.status = :status, c.updatedAt = :updatedAt WHERE c.id = :id")
    void updateCardStatus(@Param("id") Long id,
                         @Param("status") CardStatus status,
                         @Param("updatedAt") LocalDateTime updatedAt);
}
