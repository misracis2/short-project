package com.example.shortproject.dto;

import lombok.Getter;

@Getter
public class LoginDto {

    @Getter
    public static class RequestDto{
        private String loginId;

        private String password;
    }
}
