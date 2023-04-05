package com.example.shortproject.conroller;

import com.example.shortproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    //수강 신청 기능
    @PostMapping("/courses/{courseId}")
    public void addCourse(@PathVariable Long courseId, HttpServletRequest request) {
        studentService.addCourse(courseId, request);
    }

    //수강 철회 기능
    @DeleteMapping("/courses/{courseId}")
    public void cancelCourse(@PathVariable Long courseId) {

    }
}
