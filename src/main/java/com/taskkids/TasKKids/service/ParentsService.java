package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.ParentsEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.taskkids.TasKKids.repository.ParentsRepository;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentsService {

    private final ParentsRepository parentsRepository;


    public List<ParentsEntity> getAll() {
        return parentsRepository.findAll();
    }

    public ParentsEntity create(ParentsEntity newParent) {
        if (parentsRepository.findByEmail(newParent.getEmail()) != null) {
            throw new IllegalArgumentException("Cet email est déjà utilisé.");
        }
        return parentsRepository.save(newParent);
    }

    public ParentsEntity getById(Long parentId) {
        Optional<ParentsEntity> optionalParent = parentsRepository.findById(parentId);
        if (optionalParent.isEmpty()) {
            throw new EntityNotFoundException("Parent introuvable.");
        }
        return optionalParent.get();
    }


    public ParentsEntity update(Long parentId, ParentsEntity updatedParent) {
        ParentsEntity parent = getById(parentId);

        parent.setEmail(updatedParent.getEmail());
        parent.setPassword(updatedParent.getPassword());
        parent.setNickname(updatedParent.getNickname());
        parent.setPicture(updatedParent.getPicture());

        return parentsRepository.save(parent);
    }


    public ParentsEntity addChildToParent(Long id, ChildrenEntity newChild) {
        ParentsEntity parent = this.getById(id);
        parent.getChildren().add(newChild);
        return parentsRepository.save(parent);
    }

}





    
