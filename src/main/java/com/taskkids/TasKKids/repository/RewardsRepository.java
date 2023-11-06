package com.taskkids.TasKKids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskkids.TasKKids.entity.RewardsEntity;

@Repository
public interface RewardsRepository extends JpaRepository<RewardsEntity, Long> {
    
}
