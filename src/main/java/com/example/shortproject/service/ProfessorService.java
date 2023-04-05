package com.example.shortproject.service;

import com.example.shortproject.dto.CourseDto;
import com.example.shortproject.dto.ProfessorDto;
import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Enrollment;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.EnrollmentRepository;
import com.example.shortproject.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;
    private final EnrollmentRepository enrollmentRepository;

    //강의별 수강생 조회
    public ProfessorDto.CourseAndStudentDto getStudent(long courseId) {
        //강의 식별자로 학생리스트 확인
        List<Enrollment> enrollmentList = enrollmentRepository.findByCourse_CourseId(courseId);
        //강의 객체 생성
        Course course = enrollmentList.get(0).getCourse();
        //수강 학생 리스트 생성
        List<String> studentList = new ArrayList<>();
        for (Enrollment enrollment : enrollmentList) {
            studentList.add(enrollment.getStudent().getName());
        }
        return new ProfessorDto.CourseAndStudentDto(course.getTitle(),
                                                    course.getStudentNumber(),
                                                    course.getProfessor().getName(),
                                                    studentList);
    }

    //강의 정보 조회
    @Transactional(readOnly = true)
    public CourseDto.ResponseDto getCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 강의입니다.")
        );
        if(LocalDate.now().isBefore(course.getCloseDate())){
            throw new IllegalArgumentException("수강신청 기간 중입니다.");
        }else {
            return new CourseDto.ResponseDto(course.getCourseId(), course.getTitle(), course.getStudentNumber(), course.getProfessor());
        }
    }


    //교수가 강의하는 강의 목록을 조회
    @Transactional(readOnly = true)
    public List<CourseDto.ResponseDto> getCourseList(Long professorId) {
        //교수 정보 조회
        Professor professor = professorRepository.findById(professorId).orElseThrow(
                () -> new IllegalArgumentException("존재하는 않는 교수입니다.")
        );
        List<CourseDto.ResponseDto> responseDtoList = new ArrayList<>();
        //조회한 교수 정보에서 강의 목록 조회
        List<Course> CourseList = professor.getCourseList();
        //entity 정보를 dto로 옮겨 담아 반환
        for (Course course : CourseList) {
            responseDtoList.add(new CourseDto.ResponseDto(course.getCourseId(), course.getTitle(), course.getStudentNumber(), course.getProfessor()));
        }
        return responseDtoList;
    }
}
