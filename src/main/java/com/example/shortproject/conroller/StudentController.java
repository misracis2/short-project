package com.example.shortproject.conroller;

import com.example.shortproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/courses/{courseId}")
    public void addCourse(@PathVariable Long courseId, UserDetails userDetails) {
        studentService.addCourse(courseId, userDetails);
    }
}
