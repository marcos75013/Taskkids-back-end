package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.Entity.ChildrenEntity;
import com.taskkids.TasKKids.Entity.ParentsEntity;
import com.taskkids.TasKKids.service.ParentsChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bind/parents-children")
@RequiredArgsConstructor
public class ParentsChildrenController {

    private final ParentsChildrenService service;

    @PostMapping("/parentId={parentId}/childId={childId}") // http://localhost:8080/bind/parents-children/parentId=1/childId=3
    public ResponseEntity<ParentsEntity> addChildToParent(@PathVariable Long parentId, @PathVariable Long childId) {
        return new ResponseEntity<>(service.addChildToParent(parentId, childId), HttpStatus.CREATED);
    }


}
