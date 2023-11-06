package com.taskkids.TasKKids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskkids.TasKKids.repository.ChildrenRepository;

@Service
public class ChildrenService {

    private final ChildrenRepository childrenRepository;

    @Autowired
    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    // Méthodes pour les opérations sur les enfants.
}

