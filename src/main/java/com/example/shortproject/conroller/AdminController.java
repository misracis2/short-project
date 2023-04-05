package com.example.shortproject.conroller;

import com.example.shortproject.dto.AdminDto;
import com.example.shortproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/courses")
    public void addCourse(@RequestBody AdminDto.AddCoursesDto addCoursesDto) {
        adminService.addCourses(addCoursesDto);

    }
}
