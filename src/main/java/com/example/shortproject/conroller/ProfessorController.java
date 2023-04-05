package com.example.shortproject.conroller;

import com.example.shortproject.dto.CourseDto;
import com.example.shortproject.dto.ProfessorDto;
import com.example.shortproject.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/course/{courseId}")
    public CourseDto.ResponseDto getCourse(@PathVariable Long courseId) {
        return professorService.getCourse(courseId);
    }

    @GetMapping("/{professorId}/course")
    public List<CourseDto.ResponseDto> getCourseList(@PathVariable Long professorId) {
        return professorService.getCourseList(professorId);
    }

    @GetMapping("/course/{courseId}/student")
    public ProfessorDto.CourseAndStudentDto getStudent(@PathVariable long courseId){
        return professorService.getStudent(courseId);
    }
}
