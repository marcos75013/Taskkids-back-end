//package com.taskkids.TasKKids.controller;
//
//
//import com.taskkids.TasKKids.entity.ChildrenEntity;
//import com.taskkids.TasKKids.entity.ParentsEntity;
//import com.taskkids.TasKKids.service.ParentsChildrenService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/parents-children")
//@RequiredArgsConstructor
//public class ParentsChildrenController {
//
//    private final ParentsChildrenService parentsChildrenService;
//
//    //Ajouter un ou plusieurs enfants (Parent):
//    @PostMapping("profile/{parentId}/children") //Postman OK ***************************************************
//    public ResponseEntity<ParentsEntity> addChildrenToParent(@PathVariable Long parentId, @RequestBody ChildrenEntity child) {
//        ParentsEntity parent = parentsService.addChild(parentId, child);
//        return new ResponseEntity<>(parent, HttpStatus.CREATED);
//    }
//}
