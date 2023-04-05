package com.example.shortproject.conroller;

import com.example.shortproject.dto.LoginDto;
import com.example.shortproject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/professor")
    public void login(@RequestBody LoginDto.RequestDto requestDto, HttpServletResponse httpServletResponse) {
        loginService.professorLogin(requestDto, httpServletResponse);
    }
    @PostMapping("/student")
    public void studentLogin(@RequestBody LoginDto.RequestDto requestDto, HttpServletResponse httpServletResponse) {
        loginService.studentLogin(requestDto, httpServletResponse);
    }
}
