package com.example.shortproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

    public Course(String title, int studentNumber, Professor professor) {
        this.title = title;
        this.studentNumber = studentNumber;
        this.professor = professor;
    }
}
