package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //Créer un profil (Parent):
    @PostMapping("/profile")  //Postman OK ***************************************************
    public ResponseEntity<ParentsEntity> createParentProfile(@RequestBody ParentsEntity parent) {
        ParentsEntity createdParent = parentsService.createProfile(parent);
        return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
    }

    //Afficher le profil (Parent):
    @GetMapping("/profile/{parentId}") //Postman OK ***************************************************
    public ResponseEntity<ParentsEntity> getParentProfile(@PathVariable Long parentId) {
        ParentsEntity parent = parentsService.getProfile(parentId);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }
    //Modifier le profil (Parent):
    @PutMapping("/profile/{parentId}") //Postman OK ***************************************************
    public ResponseEntity<ParentsEntity> updateParentProfile(@PathVariable Long parentId, @RequestBody ParentsEntity parentDetails) {
        ParentsEntity updatedParent = parentsService.updateProfile(parentId, parentDetails);
        return new ResponseEntity<>(updatedParent, HttpStatus.OK);
    }


    //Ajouter un ou plusieurs enfants (Parent):
    @PostMapping("profile/{parentId}/children")
    public ResponseEntity<ParentsEntity> addChildrenToParent(@PathVariable Long parentId, @RequestBody ChildrenEntity child) {
        ParentsEntity parent = parentsService.addChild(parentId, child);
        return new ResponseEntity<>(parent, HttpStatus.CREATED);
    }


   //Afficher un ou plusieurs enfants (Parent):
    @PutMapping("/{parentId}/children/{childId}")
    public ResponseEntity<ParentsEntity> updateChild(@PathVariable Long parentId, @PathVariable Long childId, @RequestBody ChildrenEntity childDetails) {
        ParentsEntity parent = parentsService.updateChild(parentId, childId, childDetails);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }


    //Supprimer un ou plusieurs enfants (Parent):
    @DeleteMapping("/{parentId}/children/{childId}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long parentId, @PathVariable Long childId) {
        parentsService.deleteChild(parentId, childId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }










}

