package com.taskkids.TasKKids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.service.ParentsService;

@RestController
@RequestMapping("/parents")
public class ParentsController {

    private final ParentsService parentsService;

    @Autowired
    public ParentsController(ParentsService parentsService) {
        this.parentsService = parentsService;
    }

    @PostMapping
    public ResponseEntity<ParentsEntity> createParent(@RequestBody ParentsEntity parent) {
        return ResponseEntity.ok(parentsService.createParent(parent));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody ParentsEntity parent) {
        return ResponseEntity.ok(parentsService.login(parent));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateParent(@RequestBody ParentsEntity parent) {
        return ResponseEntity.ok(parentsService.updateParent(parent));
    }

    

}

