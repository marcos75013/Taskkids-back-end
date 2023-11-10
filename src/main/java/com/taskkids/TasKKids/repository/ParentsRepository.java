package com.taskkids.TasKKids.repository;

import com.taskkids.TasKKids.Entity.ParentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ParentsRepository extends JpaRepository<ParentsEntity, Long> {

    ParentsEntity findByEmail(String email);
}
