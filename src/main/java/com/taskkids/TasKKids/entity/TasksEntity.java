package com.taskkids.TasKKids.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tasks")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;

    private Integer rewardAmount;

    @Column
    private String periodicity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("tasks")
    private ChildrenEntity child;


    public TasksEntity(String description, int rewardAmount, String periodicity, ChildrenEntity childrenEntity) {

    }
}

