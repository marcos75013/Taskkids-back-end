package com.taskkids.TasKKids.repository;

import com.taskkids.TasKKids.Entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
    
}
