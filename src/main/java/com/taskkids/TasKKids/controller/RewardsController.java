package com.taskkids.TasKKids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskkids.TasKKids.service.RewardsService;

@RestController
@RequestMapping("/rewards")
@CrossOrigin(origins = "http://localhost:4200")
public class RewardsController {

    private final RewardsService rewardsService;

    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

}

