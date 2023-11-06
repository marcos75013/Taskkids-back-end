package com.taskkids.TasKKids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskkids.TasKKids.service.ChildrenService;

@RestController
@RequestMapping("/children")
public class ChildrenController {

    private final ChildrenService childrenService;

    @Autowired
    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }


}

