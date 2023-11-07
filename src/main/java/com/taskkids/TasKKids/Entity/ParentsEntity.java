
package com.taskkids.TasKKids.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "parents")
public class ParentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String picture;

    // Relation avec ChildrenEntity
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("parent")
    private Set<ChildrenEntity> children = new HashSet<>();

    // Relation avec TasksEntity
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private Set<TasksEntity> tasks = new HashSet<>();

    // Relation avec RewardsEntity
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private Set<RewardsEntity> rewards = new HashSet<>();
}

