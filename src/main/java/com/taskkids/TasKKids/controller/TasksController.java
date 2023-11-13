package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.entity.TasksEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskkids.TasKKids.service.TasksService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @GetMapping
    public ResponseEntity<List<TasksEntity>> getAll() {
        return new ResponseEntity<>(tasksService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TasksEntity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(tasksService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TasksEntity> create(@RequestBody TasksEntity newTask) {
        return new ResponseEntity<>(tasksService.create(newTask), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TasksEntity> update(@PathVariable Long id, @RequestBody TasksEntity updatedTask) {
        return new ResponseEntity<>(tasksService.update(id, updatedTask), HttpStatus.OK);
    }

}

