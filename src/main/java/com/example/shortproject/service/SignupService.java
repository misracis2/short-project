package com.example.shortproject.service;

import com.example.shortproject.dto.MemberDto;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.entity.Student;
import com.example.shortproject.repository.ProfessorRepository;
import com.example.shortproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public void professorSignup(MemberDto.ProfessorDto professorDto) {
        professorRepository.save(new Professor(professorDto.getLoginId(), professorDto.getPassword(), professorDto.getName()));
    }
    @Transactional
    public void studentSignup(MemberDto.StudentDto studentDto) {
        studentRepository.save(new Student(studentDto.getLoginId(), studentDto.getPassword(), studentDto.getName()));
    }
}
