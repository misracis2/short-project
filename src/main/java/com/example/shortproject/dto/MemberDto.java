package com.example.shortproject.dto;

import lombok.Getter;

public class MemberDto {

    @Getter
    public static class ProfessorDto{
        String loginId;
        String password;
        String name;
    }


    @Getter
    public static class StudentDto{
        String loginId;
        String password;
        String name;
    }
}
