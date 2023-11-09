package com.taskkids.TasKKids.controller;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.service.ParentsService;
import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentsController {

    private final ParentsService parentsService;

    @GetMapping("/parents") //Postman OK ***************************************************
    public ResponseEntity<List<ParentsEntity>> getParents() {
        return new ResponseEntity<>(parentsService.getAll(),HttpStatus.OK);
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
    @PostMapping("profile/{parentId}/children") //Postman OK ***************************************************
    public ResponseEntity<ParentsEntity> addChildrenToParent(@PathVariable Long parentId, @RequestBody ChildrenEntity child) {
        ParentsEntity parent = parentsService.addChild(parentId, child);
        return new ResponseEntity<>(parent, HttpStatus.CREATED);
    }


   //update un ou plusieurs enfants (Parent):
    @PutMapping("/profile/{parentId}/children/update/{childId}") //Postman OK ***************************************************
    public ResponseEntity<ParentsEntity> updateChild(@PathVariable Long parentId, @PathVariable Long childId, @RequestBody ChildrenEntity childDetails) {
        ParentsEntity parent = parentsService.updateChild(parentId, childId, childDetails);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }


    //Supprimer un ou plusieurs enfants (Parent):
    @DeleteMapping("/profile/{parentId}/children/delete/{childId}") //Postman OK ***************************************************
    public ResponseEntity<Void> deleteChild(@PathVariable Long parentId, @PathVariable Long childId) {
        parentsService.deleteChild(parentId, childId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    //rajouter une ou plusieurs tâches à un ou plusieurs enfants (Parent):   ////pas encore de servive
   @PostMapping("/{parentId}/children/{childId}/tasks") //XXXXXXXXXXXXXXXX ne fonctionne pas
   public ResponseEntity<ParentsEntity> addTasksToChild(@PathVariable Long parentId, @PathVariable Long childId, @RequestBody TasksEntity task) {
       ParentsEntity parent = parentsService.addTaskToChild(parentId, childId, task);
       return new ResponseEntity<>(parent, HttpStatus.CREATED);
}
//
//    //modifier une ou plusieurs tâches à un ou plusieurs enfants (Parent):   ////pas encore de servive
    @PutMapping("/profile/{parentId}/children/{childId}/tasks/{taskId}")
    public ResponseEntity<ParentsEntity> updateTask(@PathVariable Long parentId, @PathVariable Long childId, @PathVariable Long taskId, @RequestBody TasksEntity taskDetails) {
        ParentsEntity parent = parentsService.updateTask(parentId, childId, taskId, taskDetails);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }
//
//    //supprimer une ou plusieurs tâches à un ou plusieurs enfants (Parent):   ////pas encore de servive
    @DeleteMapping("/profile/{parentId}/children/{childId}/tasks/{taskId}/delete")
    public ResponseEntity<Void> deleteTask(@PathVariable Long parentId, @PathVariable Long childId, @PathVariable Long taskId) {
        parentsService.deleteTask(parentId, childId, taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//
//    //afficher les tâches d'un ou plusieurs enfants (Parent):   ////pas encore de servive
    @GetMapping("/profile/{parentId}/children/{childId}/tasks")
    public ResponseEntity<List<TasksEntity>> getTasks(@PathVariable Long parentId, @PathVariable Long childId) {
        List<TasksEntity> tasks = parentsService.getTasks(parentId, childId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    //comptez les points d'un enfants et afficher dans la table score

    @GetMapping("/profile/{parentId}/children/{childId}/score")
    public ResponseEntity<Integer> getScore(@PathVariable Long parentId, @PathVariable Long childId) {
        Integer score = parentsService.getScore(parentId, childId);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }












}

