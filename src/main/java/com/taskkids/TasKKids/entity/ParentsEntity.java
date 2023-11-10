package com.taskkids.TasKKids.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String picture;

    // Relation avec ChildrenEntity
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonIgnoreProperties("parent")
    private Set<ChildrenEntity> children = new HashSet<>();




    // Relation avec RewardsEntity
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonIgnoreProperties("parent")
    private Set<RewardsEntity> rewards = new HashSet<>();
}

