package com.example.shortproject.service;

import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Enrollment;
import com.example.shortproject.entity.Student;
import com.example.shortproject.jwt.JwtUtil;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.EnrollmentRepository;
import com.example.shortproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    private final JwtUtil jwtUtil;

    //수강신청
    @Transactional
    public void addCourse(Long courseId, HttpServletRequest request) {
        String loginId = jwtUtil.getLoginId(request);   //토큰에서 학생 아이디 추출
        Student student = checkEnrollmentNumber(loginId);   //학생 데이터 조회 및 수강 강의 수 확인
        Course course = checkStudentNumber(courseId);   //강의 조회 및 정원 초과 여부 확인
        enrollmentRepository.save(new Enrollment(student, course)); //수강 등록
        course.increaseStudentNumber(); //수강인원 증가
        student.increaseEnrollmentNumber(); //수강 과목 증가
    }

    //수강 철회
    @Transactional
    public void cancelCourse(Long courseId, HttpServletRequest request) {
        String loginId = jwtUtil.getLoginId(request);
        Student student = studentRepository.findByLoginId(loginId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 학생입니다.")
        );
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 하는 강의입니다.")
        );


        if (Period.between(LocalDate.now(), course.getCloseDate()).getDays() <= 3) {
            throw new IllegalArgumentException("마감 3일 전에는 수강신청 취소가 불가능합니다.");
        }else {
            enrollmentRepository.delete(new Enrollment(student, course));   //수강 취소
            course.decreaseStudentNumber(); //수강 인원 감소
            student.decreaseEnrollmentNumber(); //수강 과목 감소
        }
    }


    private Student checkEnrollmentNumber(String loginId) {
        Student student = studentRepository.findByLoginId(loginId).orElseThrow(
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
