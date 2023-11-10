package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.Entity.ChildrenEntity;
import com.taskkids.TasKKids.Entity.ParentsEntity;
import com.taskkids.TasKKids.Entity.TasksEntity;
import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public ResponseEntity<List<ChildrenEntity>> getAll() {
        return new ResponseEntity<>(childrenService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildrenEntity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(childrenService.getById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<ChildrenEntity> update(@PathVariable Long id, @RequestBody ChildrenEntity newChild) {
        return new ResponseEntity<>(childrenService.update(id, newChild),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        childrenService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/{id}/add-task")
    public ResponseEntity<ChildrenEntity> addTaskToChild(@PathVariable Long id, @RequestBody TasksEntity newTask) {
        return new ResponseEntity(childrenService.addTaskToChild(id, newTask), HttpStatus.CREATED);
    }

}

