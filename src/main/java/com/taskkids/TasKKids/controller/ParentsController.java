package com.taskkids.TasKKids.controller;


import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.ParentsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taskkids.TasKKids.service.ParentsService;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ParentsController {

    private final ParentsService parentsService;

    @GetMapping
    public ResponseEntity<List<ParentsEntity>> getAll() {
        return new ResponseEntity<>(parentsService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentsEntity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(parentsService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParentsEntity> create(@RequestBody ParentsEntity newParent) {
        return new ResponseEntity<>(parentsService.create(newParent), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ParentsEntity> login(@RequestBody Map<String, String> credentials) {
        try {
            ParentsEntity parent = parentsService.login(credentials.get("email"), credentials.get("password"));
            return new ResponseEntity<>(parent, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentsEntity> update(@PathVariable Long id, @RequestBody ParentsEntity updatedParent) {
        return new ResponseEntity<>(parentsService.update(id, updatedParent), HttpStatus.OK);
    }

    @PostMapping("/{id}/add-child")
    public ResponseEntity<ParentsEntity> addChildToParent(@PathVariable Long id, @RequestBody ChildrenEntity newChild) {
        return new ResponseEntity<>(parentsService.addChildToParent(id, newChild), HttpStatus.CREATED);
    }


}
