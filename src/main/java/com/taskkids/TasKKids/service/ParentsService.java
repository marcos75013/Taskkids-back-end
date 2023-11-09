package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import com.taskkids.TasKKids.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.repository.ParentsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentsService {

    private final ParentsRepository parentsRepository;
    private final ChildrenRepository childrenRepository;

    private final TasksRepository tasksRepository;

    ///////////////////////////////////////////////
    public List<ParentsEntity> getAll() {
        return parentsRepository.findAll();
    } ///////////OK

    public ParentsEntity createProfile(ParentsEntity parent) {   ///////////OK
        if (parentsRepository.findByEmail(parent.getEmail()) != null) {
            throw new IllegalArgumentException("Cet email est déjà utilisé.");
        }
        parent.setNickname("Nouveau Parent");
        return parentsRepository.save(parent);
    }

    public ParentsEntity getProfile(Long parentId) {  ///////////OK
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }
        return optionalParent.get();
    }

    ///////////////////////////////////////////////////////////////////

    public ParentsEntity updateProfile(Long parentId, ParentsEntity parentDetails) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        ParentsEntity parent = optionalParent.get();
        if (parentDetails.getEmail() != null) {
            parent.setEmail(parentDetails.getEmail());
        }
        if (parentDetails.getPassword() != null) {
            parent.setPassword(parentDetails.getPassword());
        }
        if (parentDetails.getNickname() != null) {
            parent.setNickname(parentDetails.getNickname());
        }
        if (parentDetails.getPicture() != null) {
            parent.setPicture(parentDetails.getPicture());
        }

        return parentsRepository.save(parent);
    }
    ///////////////////////////////////////////////////////////////////

    public ParentsEntity addChild(Long parentId, ChildrenEntity child) {

        // Get parent if exists, oterwise throw new exception
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }
        ParentsEntity parent = optionalParent.get();

        // set fetched parent into received child
        child.setParent(parent);
        // set recevied cil into fetched parent
        parent.getChildren().add(child);

        // save entities into both repositories
        childrenRepository.save(child);
        parentsRepository.save(parent);

        return parent;
    }
    /////////////////////////////////////////////////////////////////

    @Transactional
    public ParentsEntity updateChild(Long parentId, Long childId, ChildrenEntity childDetails) {
        // Vérifie si le parent existe
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        // Vérifie si l'enfant existe
        ParentsEntity parent = optionalParent.get();
        Optional<ChildrenEntity> optionalChild = parent.getChildren().stream().filter(child -> child.getChildId().equals(childId)).findFirst();
        if (optionalChild.isEmpty()) {
            throw new IllegalArgumentException("Enfant introuvable.");
        }

        // Je mets à jour les champs modifiables
        ChildrenEntity child = optionalChild.get();
        if (childDetails.getNickname() != null) {
            child.setNickname(childDetails.getNickname());
        }
        if (childDetails.getPicture() != null) {
            child.setPicture(childDetails.getPicture());
        }
        if (childDetails.getGender() != null) {
            child.setGender(childDetails.getGender());
        }
        if (childDetails.getAge() != null) {
            child.setAge(childDetails.getAge());
        }

        parentsRepository.save(parent);

        return parent;
    }

    ///////////////////////////////////////////////

    @Transactional
    public void deleteChild(Long parentId, Long childId) {
        // Vérifie si le parent existe
        ParentsEntity parent = parentsRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("Parent introuvable."));

        // Vérifie si l'enfant existe
        ChildrenEntity child = parent.getChildren().stream()
                .filter(c -> c.getChildId().equals(childId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Enfant introuvable."));

        // Retire l'enfant de la collection
        parent.getChildren().remove(child);

        // Dissocie l'enfant du parent
        child.setParent(null);

        // Supprime l'enfant de la base de données
        childrenRepository.delete(child);

        // Pas nécessaire de sauvegarder le parent si tu n'as pas modifié d'autres attributs
        // La relation entre le parent et l'enfant devrait s'occuper de la cohérence des données
    }


    ///////////////////////////////////////////////

    @Transactional
    public ParentsEntity addTaskToChild(Long parentId, Long childId, TasksEntity task) {
        ChildrenEntity child = childrenRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("Enfant introuvable."));

        if (!child.getParent().getParentId().equals(parentId)) {
            throw new IllegalArgumentException("L'enfant n'appartient pas au parent.");
        }

        task.setChild(child);

        child.getTasks().add(task);

        childrenRepository.save(child);

        return child.getParent();
    }


    ///////////////////////////////////////////////

    public ParentsEntity updateTask(Long parentId, Long childId, Long taskId, TasksEntity taskDetails) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        ParentsEntity parent = optionalParent.get();
        Optional<ChildrenEntity> optionalChild = parent.getChildren().stream().filter(child -> child.getChildId().equals(childId)).findFirst();
        if (optionalChild.isEmpty()) {
            throw new IllegalArgumentException("Enfant introuvable.");
        }

        ChildrenEntity child = optionalChild.get();
        Optional<TasksEntity> optionalTask = child.getTasks().stream().filter(task -> task.getTaskId().equals(taskId)).findFirst();
        if (optionalTask.isEmpty()) {
            throw new IllegalArgumentException("Tâche introuvable.");
        }

        TasksEntity task = optionalTask.get();
        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getRewardAmount() != null) {
            task.setRewardAmount(taskDetails.getRewardAmount());
        }

        childrenRepository.save(child);
        parentsRepository.save(parent);

        return parent;
    }

    ///////////////////////////////////////////////
    public void deleteTask(Long parentId, Long childId, Long taskId) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        ParentsEntity parent = optionalParent.get();
        Optional<ChildrenEntity> optionalChild = parent.getChildren().stream().filter(child -> child.getChildId().equals(childId)).findFirst();
        if (optionalChild.isEmpty()) {
            throw new IllegalArgumentException("Enfant introuvable.");
        }

        ChildrenEntity child = optionalChild.get();
        Optional<TasksEntity> optionalTask = child.getTasks().stream().filter(task -> task.getTaskId().equals(taskId)).findFirst();
        if (optionalTask.isEmpty()) {
            throw new IllegalArgumentException("Tâche introuvable.");
        }

        TasksEntity task = optionalTask.get();
        child.getTasks().remove(task);
        task.setChild(null);

        childrenRepository.save(child);
        parentsRepository.save(parent);
    }

    ///////////////////////////////////////////////

    public List<TasksEntity> getTasks(Long parentId, Long childId) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        ParentsEntity parent = optionalParent.get();
        Optional<ChildrenEntity> optionalChild = parent.getChildren().stream().filter(child -> child.getChildId().equals(childId)).findFirst();
        if (optionalChild.isEmpty()) {
            throw new IllegalArgumentException("Enfant introuvable.");
        }

        ChildrenEntity child = optionalChild.get();
        return (List<TasksEntity>) child.getTasks();
    }

    ///////////////////////////////////////////////

    public Integer getScore(Long parentId, Long childId) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new IllegalArgumentException("Parent introuvable.");
        }

        ParentsEntity parent = optionalParent.get();
        Optional<ChildrenEntity> optionalChild = parent.getChildren().stream().filter(child -> child.getChildId().equals(childId)).findFirst();
        if (optionalChild.isEmpty()) {
            throw new IllegalArgumentException("Enfant introuvable.");
        }

        ChildrenEntity child = optionalChild.get();
        return child.getScores().stream().mapToInt(score -> score.getScore()).sum();
    }

    ///////////////////////////////



}





    
