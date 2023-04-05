package com.example.shortproject.dto;

import lombok.Getter;

import java.util.List;

public class ProfessorDto {

    @Getter
    public static class CourseAndStudentDto{

        private String title;

        private int studentNumber;

        private String professorName;

        //학생정보 추가 시 계쏙 추가
        private List<String> studentNameList;

        public CourseAndStudentDto(String title, int studentNumber, String professorName, List<String> studentNameList) {
            this.title = title;
            this.studentNumber = studentNumber;
            this.professorName = professorName;
            this.studentNameList = studentNameList;
        }
    }
}
