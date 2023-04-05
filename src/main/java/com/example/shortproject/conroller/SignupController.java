package com.example.shortproject.conroller;

import com.example.shortproject.dto.MemberDto;
import com.example.shortproject.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/professor")
    public void professorSignup(@RequestBody MemberDto.ProfessorDto professorDto) {
        signupService.professorSignup(professorDto);
    }

    @PostMapping("/student")
    public void studentSignup(@RequestBody MemberDto.StudentDto studentDto) {
        signupService.studentSignup(studentDto);
    }

}
