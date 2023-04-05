package com.example.shortproject.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AdminDto {

    @Getter
    public static class AddCoursesDto{

        @NotBlank(message = "강의 제목을 입력해주세요.")
        private String title;

        //클라이언트에서 학생을 추가하고 인원수를 넘겨주는 것으로 가정
        @Min(6)
        @Max(15)
        private int studentNumber;

        @NotBlank(message = "담당 교수명을 입력해주세요.")
        private String professorName;


    }
}
