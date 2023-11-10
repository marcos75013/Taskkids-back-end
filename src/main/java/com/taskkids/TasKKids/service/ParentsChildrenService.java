package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.Entity.ChildrenEntity;
import com.taskkids.TasKKids.Entity.ParentsEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import com.taskkids.TasKKids.repository.ParentsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentsChildrenService {

    private final ParentsRepository parentsRepository;
    private final ChildrenRepository childrenRepository;


    public ParentsEntity addChildToParent(Long parentId, Long childId) {
        ParentsEntity parent = this.parentsRepository.findById(parentId).orElseThrow(() -> new EntityNotFoundException(parentId + " does not exist"));
        ChildrenEntity child = this.childrenRepository.findById(childId).orElseThrow(() -> new EntityNotFoundException(childId + " does not exist"));

        parent.getChildren().add(child);

        parentsRepository.save(parent);

        return parent;
    }
}
