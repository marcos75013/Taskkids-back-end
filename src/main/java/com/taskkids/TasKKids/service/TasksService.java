package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.Entity.TasksEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskkids.TasKKids.repository.TasksRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;


    public List<TasksEntity> getAll() {
        return tasksRepository.findAll();
    }


    public TasksEntity getById(Long id) {
        return tasksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("can't found id " + id));
    }

    public TasksEntity create(TasksEntity newTask) {
        return tasksRepository.save(newTask);
    }

    public TasksEntity update(Long id, TasksEntity updatedTask) {
        TasksEntity taskFoundInDB = getById(id);

        taskFoundInDB.setDescription(updatedTask.getDescription());
        taskFoundInDB.setPeriodicity(updatedTask.getPeriodicity());
        taskFoundInDB.setRewardAmount(updatedTask.getRewardAmount());

        return tasksRepository.save(taskFoundInDB);
    }
}

