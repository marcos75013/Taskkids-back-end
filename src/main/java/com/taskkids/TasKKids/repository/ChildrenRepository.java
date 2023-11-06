package com.taskkids.TasKKids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskkids.TasKKids.entity.ChildrenEntity;

@Repository
public interface ChildrenRepository extends JpaRepository<ChildrenEntity, Long> {
    
}
