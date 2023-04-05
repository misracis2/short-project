package com.example.shortproject;

import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.entity.Student;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.ProfessorRepository;
import com.example.shortproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstruct {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @javax.annotation.PostConstruct
    public void init(){
        Professor professorKim = new Professor("professorKim", "1234", "김교수");
        Professor professorLee = new Professor("professorLee", "1234", "이교수");
        Professor professorChoi = new Professor("professorChoi", "1234", "최교수");

        professorRepository.save(professorKim);
        professorRepository.save(professorLee);
        professorRepository.save(professorChoi);

        courseRepository.save(new Course("물리학 개론", 6, professorKim));
        courseRepository.save(new Course("전자기학 개론", 6, professorKim));
        courseRepository.save(new Course("국제정치학", 6, professorLee));
        courseRepository.save(new Course("헌번론", 6, professorLee));
        courseRepository.save(new Course("사회복지학 개론", 6, professorChoi));

        for(int i = 1 ; i<=30; i++){
            studentRepository.save(new Student("김학생"+i,"1234","김학생"+i));
        }
    }

}
