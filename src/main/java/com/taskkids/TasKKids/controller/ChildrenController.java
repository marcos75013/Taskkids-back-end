package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskkids.TasKKids.service.ChildrenService;

import java.util.List;

@RestController
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildrenController {

    private final ChildrenService childrenService;


}

