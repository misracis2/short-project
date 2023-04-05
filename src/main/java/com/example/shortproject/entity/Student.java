package com.example.shortproject.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private int enrollmentNumber;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollmentList;
}
