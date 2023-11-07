package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.repository.ParentsRepository;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentsService {

    private final ParentsRepository parentsRepository;
    private final ChildrenRepository childrenRepository;

    ///////////////////////////////////////////////
    public List<ParentsEntity> getAll() {
        return parentsRepository.findAll();
    }

    public ParentsEntity createProfile(ParentsEntity parent) {
        if (parentsRepository.findByEmail(parent.getEmail()) != null) {
            throw new IllegalArgumentException("Cet email est déjà utilisé.");
        }
        parent.setNickname("Nouveau Parent");
        return parentsRepository.save(parent);
    }

    public ParentsEntity getProfile(Long parentId) {
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
        if (childDetails.getFirstName() != null) {
            child.setFirstName(childDetails.getFirstName());
        }
        if (childDetails.getLastName() != null) {
            child.setLastName(childDetails.getLastName());
        }
        if (childDetails.getBirthDate() != null) {
            child.setBirthDate(childDetails.getBirthDate());
        }

        parentsRepository.save(parent);

        return parent;
    }

    ///////////////////////////////////////////////

    public void deleteChild(Long parentId, Long childId) {
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
        parent.getChildren().remove(child);
        child.setParent(null);

        parentsRepository.save(parent);
    }

    ///////////////////////////////







}





    
