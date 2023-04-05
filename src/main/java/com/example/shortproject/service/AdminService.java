package com.example.shortproject.service;

import com.example.shortproject.dto.AdminDto;
import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ProfessorRepository professorRepository;

    private final CourseRepository courseRepository;

    @Transactional
    public void addCourses(AdminDto.AddCoursesDto addCoursesDto) {
        //담당 교수 확인
        Professor professor = professorRepository.findByName(addCoursesDto.getProfessorName()).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 교수명입니다.")
        );
        //강의 개수 확인
        if(professor.getCourseNumber() >= 2){
            throw new IllegalArgumentException("최대 강의수를 초과합니다.");
        }else {
            //강의 추가
            courseRepository.save(new Course(addCoursesDto.getTitle(), addCoursesDto.getStudentNumber(), professor));
            professor.increaseCourseNumber();
        }

    }
}
