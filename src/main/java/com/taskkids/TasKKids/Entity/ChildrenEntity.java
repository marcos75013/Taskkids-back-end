
package com.taskkids.TasKKids.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString
@NoArgsConstructor
@Entity
@Table(name = "children")
public class ChildrenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;

    private String nickname;

    @Column
    private String picture;

    @Column
    private String gender;

    @Column
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("child")
    private ParentsEntity parent;

    // Relation avec TasksEntity
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "child_id", nullable = false)
    @JsonIgnoreProperties("child")
    private Set<TasksEntity> tasks = new HashSet<>();

    // Relation avec ScoreEntity
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ScoreEntity> scores = new HashSet<>();


//    public Object getFirstName() {
//        return null;
//    }
//
//    public void setFirstName(Object firstName) {
//    }
//
//    public Object getLastName() {
//        return null;
//    }
//
//    public Object getBirthDate() {
//        return null;
//    }
//
//    public void setLastName(Object lastName) {
//    }
//
//    public void setBirthDate(Object birthDate) {
//    }
}

    





