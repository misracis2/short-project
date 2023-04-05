package com.example.shortproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Student extends Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String loginId;

    private String password;

    private String name;

    @Max(3)
    private int enrollmentNumber;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Enrollment> enrollmentList;

    public Student(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.enrollmentNumber = 0;
        this.memberRole = MemberRole.STUDENT;
    }
}
