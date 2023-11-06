package com.taskkids.TasKKids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskkids.TasKKids.entity.ParentsEntity;

@Repository
public interface ParentsRepository extends JpaRepository<ParentsEntity, Long> {
    
}
