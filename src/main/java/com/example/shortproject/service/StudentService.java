package com.example.shortproject.service;

import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Enrollment;
import com.example.shortproject.entity.Student;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.EnrollmentRepository;
import com.example.shortproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    @Transactional
    public void addCourse(Long courseId, UserDetails userDetails) {
        Student student = checkEnrollmentNumber(userDetails);
        Course course = checkStudentNumber(courseId);
        enrollmentRepository.save(new Enrollment(student, course));
        course.increaseStudentNumber();
        student.increaseEnrollmentNumber();
    }

    private Student checkEnrollmentNumber(UserDetails userDetails) {
        Student student = studentRepository.findByLoginId(userDetails.getUsername()).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 학생입니다.")
        );
        if(student.getEnrollmentNumber()>=3){
            throw new IllegalArgumentException("수강 가능한 최대 강의수를 초과하였습니다.");
        }
        return student;
    }

    private Course checkStudentNumber(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 하는 강의입니다.")
        );
        if(course.getStudentNumber() >= 15 ){
            throw new IllegalArgumentException("정원을 초과하였습니다.");
        }
        return course;
    }
}
