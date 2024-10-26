package com.bank.backend.persistance.jpa;

import com.bank.backend.persistance.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardJpaRepository extends JpaRepository<CardEntity,Long> {
}
