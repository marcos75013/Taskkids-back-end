package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import com.taskkids.TasKKids.repository.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildrenService {

    private final ChildrenRepository childrenRepository;
    private final TasksRepository tasksRepository;

    public List<ChildrenEntity> getAll() {
        return childrenRepository.findAll();
    }

    public ChildrenEntity getById(Long id) {
        return childrenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("can't found id " + id));
    }

    public ChildrenEntity update(Long id, ChildrenEntity newChild) {
        ChildrenEntity child = getById(id);

        child.setAge(newChild.getAge());
        child.setPicture(newChild.getPicture());
        child.setGender(newChild.getGender());
        child.setNickname(newChild.getNickname());
        child.setScores(newChild.getScores());

        return childrenRepository.save(child);
    }

    public void delete(Long id) {
        childrenRepository.deleteById(id);
    }

    public ChildrenEntity addTaskToChild(Long id, TasksEntity newTask) {

        tasksRepository.save(newTask);

        ChildrenEntity child = this.getById(id);

        child.getTasks().add(newTask);
        return childrenRepository.save(child);
    }


}


