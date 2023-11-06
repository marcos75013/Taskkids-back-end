package com.taskkids.TasKKids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskkids.TasKKids.repository.RewardsRepository;

@Service
public class RewardsService {

    private final RewardsRepository rewardsRepository;

    @Autowired
    public RewardsService(RewardsRepository rewardsRepository) {
        this.rewardsRepository = rewardsRepository;
    }

    // Méthodes pour les opérations sur les récompenses.
}

