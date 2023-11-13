package com.taskkids.TasKKids.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "children")
public class ChildrenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String picture;

    @Column
    private String gender;

    @Column
    private Integer age;

    @Column
    private int scores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ParentsEntity parent;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "child_id", referencedColumnName ="id")
    @JsonIgnoreProperties("child")
    private Set<TasksEntity> tasks = new HashSet<>();


    public ChildrenEntity(String nickname, String picture, String gender, int age, int score, ParentsEntity parentsEntity) {

    }
}

    





