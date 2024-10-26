package com.bank.backend.persistance.jpa;

import com.bank.backend.persistance.entity.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsJpaRepository extends JpaRepository<CardsEntity,Long> {
}
