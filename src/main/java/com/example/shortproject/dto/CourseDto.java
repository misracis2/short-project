package com.example.shortproject.dto;

import com.example.shortproject.entity.Professor;
import lombok.Getter;

public class CourseDto {

    @Getter
    public static class ResponseDto {
        private Long courseId;

        private String title;

        private int studentNumber;

        private Professor professor;

        public ResponseDto(Long courseId, String title, int studentNumber, Professor professor) {
            this.courseId = courseId;
            this.title = title;
            this.studentNumber = studentNumber;
            this.professor = professor;
        }
    }
}
