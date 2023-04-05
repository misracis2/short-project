package com.example.shortproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;

    @Min(6)
    @Max(15)
    private int studentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public Course(String title, int studentNumber, Professor professor) {
        this.title = title;
        this.studentNumber = studentNumber;
        this.professor = professor;
    }
}
