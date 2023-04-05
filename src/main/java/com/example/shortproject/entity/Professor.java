package com.example.shortproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String name;

    @Max(2)
    private int courseNumber;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Course> CourseList;

    public Professor(String name) {
        this.name = name;
        this.courseNumber = 0;
        this.memberRole = MemberRole.PROFESSOR;
    }
    public void increaseCourseNumber(){
        courseNumber++;
    }
    public void decreaseCourseNumber(){
        courseNumber--;
    }
}
