package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import com.taskkids.TasKKids.repository.ParentsRepository;
import com.taskkids.TasKKids.repository.RewardsRepository;
import com.taskkids.TasKKids.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class DBGenerator {

    private final ParentsRepository parentsRepository;
    private final ChildrenRepository childrenRepository;
    private final TasksRepository tasksRepository;
    private final RewardsRepository rewardsRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Autowired
    public DBGenerator(BCryptPasswordEncoder bCryptPasswordEncoder, ParentsRepository parentsRepository, ChildrenRepository childrenRepository, TasksRepository tasksRepository, RewardsRepository rewardsRepository
    ) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.parentsRepository = parentsRepository;
        this.childrenRepository = childrenRepository;
        this.tasksRepository = tasksRepository;
        this.rewardsRepository = rewardsRepository;



    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = Exception.class)
    public void generate() {
        List<ParentsEntity> parents = new ArrayList<>();
        parents.add(new ParentsEntity("marcos@email.com", bCryptPasswordEncoder.encode("password1"), "Marquinhos", "picture1"));
        parents.add(new ParentsEntity("Rachid@email.com", bCryptPasswordEncoder.encode("password2"), "Farid", "picture2"));
        parents.add(new ParentsEntity("Aurelie@email.com", bCryptPasswordEncoder.encode("password3"), "Aurélie", "picture3"));
        parentsRepository.saveAll(parents);

        List<ChildrenEntity> children = new ArrayList<>();
        children.add(new ChildrenEntity("Paloma", "picture1", "Fille", 10, 100, parents.get(0)));
        children.add(new ChildrenEntity("Vinicius", "picture2", "Garçon", 12, 120, parents.get(0)));
        children.add(new ChildrenEntity("Thaïs", "picture3", "Fille", 13, 130, parents.get(1)));
        children.add(new ChildrenEntity("Richard", "picture4", "Non Genré", 14, 140, parents.get(1)));
        children.add(new ChildrenEntity("Matteo", "picture5", "Garçon", 15, 150, parents.get(2)));
        children.add(new ChildrenEntity("Bernadette", "picture6", "Fille", 16, 160, parents.get(2)));
        parentsRepository.saveAll(parents);
        childrenRepository.saveAll(children);

        List<TasksEntity> tasks = new ArrayList<>();
        tasks.add(new TasksEntity("Description 1", 10, "quotidienne", children.get(0)));
        tasks.add(new TasksEntity("Description 2", 15, "hebdomadaire", children.get(0)));
        tasks.add(new TasksEntity("Description 3", 20, "quotidienne", children.get(1)));
        tasks.add(new TasksEntity("Description 4", 25, "hebdomadaire", children.get(1)));
        tasks.add(new TasksEntity("Description 5", 30, "quotidienne", children.get(2)));
        tasks.add(new TasksEntity("Description 6", 35, "hebdomadaire", children.get(2)));
        tasks.add(new TasksEntity("Description 7", 40, "quotidienne", children.get(3)));
        tasks.add(new TasksEntity("Description 8", 45, "hebdomadaire", children.get(3)));
        tasks.add(new TasksEntity("Description 9", 50, "quotidienne", children.get(4)));
        tasks.add(new TasksEntity("Description 10", 55, "hebdomadaire", children.get(4)));
        tasks.add(new TasksEntity("Description 11", 60, "quotidienne", children.get(5)));
        childrenRepository.saveAll(children);
        tasksRepository.saveAll(tasks);


    }
    }


