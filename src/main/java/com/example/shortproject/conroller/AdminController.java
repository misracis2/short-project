package com.example.shortproject.conroller;

import com.example.shortproject.dto.AdminDto;
import com.example.shortproject.dto.CourseDto;
import com.example.shortproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/courses")
    public void addCourse(@RequestBody AdminDto.AddCoursesDto addCoursesDto) {
        adminService.addCourses(addCoursesDto);
    }

    @PostMapping("/course/registration")
    public void registration(@RequestBody CourseDto.RegistrationDto registrationDto) throws ParseException {
        //LocalDate 타입으로 전환
        LocalDate openDate = LocalDate.parse(registrationDto.getOpenDate(), DateTimeFormatter.ISO_DATE);
        LocalDate closeDate = LocalDate.parse(registrationDto.getCloseDate(), DateTimeFormatter.ISO_DATE);
        adminService.changePeriod(registrationDto.getCourseId(),
                registrationDto.getTitle(),
                registrationDto.getProfessorName(),
                openDate, closeDate);
    }
}
