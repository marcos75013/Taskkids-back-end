
package com.taskkids.TasKKids.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tasks")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer rewardAmount;

    @Column
    private String periodicity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tasks")
    private ChildrenEntity child;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tasks")
    private ParentsEntity parent;



}

