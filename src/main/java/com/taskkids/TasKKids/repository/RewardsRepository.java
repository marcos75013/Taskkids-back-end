package com.taskkids.TasKKids.repository;

import com.taskkids.TasKKids.entity.RewardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RewardsRepository extends JpaRepository<RewardsEntity, Long> {
    
}
