package com.taskkids.TasKKids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskkids.TasKKids.entity.TasksEntity;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
    
}
