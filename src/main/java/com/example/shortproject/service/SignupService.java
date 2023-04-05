package com.example.shortproject.service;

import com.example.shortproject.dto.MemberDto;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final ProfessorRepository professorRepository;

    public void professorSignup(MemberDto.ProfessorDto professorDto) {
        professorRepository.save(new Professor(professorDto.getName()));
    }

    public void studentSignup(MemberDto.StudentDto studentDto) {
    }
}
