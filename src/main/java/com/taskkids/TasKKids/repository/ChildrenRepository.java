package com.taskkids.TasKKids.repository;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ChildrenRepository extends JpaRepository<ChildrenEntity, Long> {
    
}
