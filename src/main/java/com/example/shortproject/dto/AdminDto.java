package com.example.shortproject.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminDto {

    @Getter
    public static class AddCoursesDto{

        @NotBlank(message = "강의 제목을 입력해주세요.")
        private String title;

        //클라이언트에서 학생을 추가하고 인원수를 넘겨주는 것으로 가정
        @Size(min = 6, max = 15, message = "수강생은 최소 6명, 최대 15명입니다.")
        private int studentNumber;

        @NotBlank(message = "담당 교수명을 입력해주세요.")
        private String professorName;


    }
}
