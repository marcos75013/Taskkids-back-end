package com.taskkids.TasKKids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.repository.ParentsRepository;

@Service
public class ParentsService {

    @Autowired
    private ParentsRepository parentsRepository;

    public ParentsEntity createParent(ParentsEntity parent) {
        return parentsRepository.save(parent);
    }

    public Object login(ParentsEntity parent) {
        return null;
    }

    public Object updateParent(ParentsEntity parent) {
        return null;
    }
}

    
