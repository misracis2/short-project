package com.example.shortproject.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;

    @Size(min = 6, max = 15)
    private int studentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;

    public Course(String title, int studentNumber, Professor professor) {
        this.title = title;
        this.studentNumber = studentNumber;
        this.professor = professor;
    }
}
