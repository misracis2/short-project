package com.example.shortproject;

import com.example.shortproject.entity.Course;
import com.example.shortproject.entity.Professor;
import com.example.shortproject.repository.CourseRepository;
import com.example.shortproject.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstruct {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @javax.annotation.PostConstruct
    public void init(){
        Professor professorKim = new Professor("김교수");
        Professor professorLee = new Professor("이교수");
        Professor professorChoi = new Professor("최교수");

        professorRepository.save(professorKim);
        professorRepository.save(professorLee);
        professorRepository.save(professorChoi);

        courseRepository.save(new Course("물리학 개론", 6, professorKim));
        courseRepository.save(new Course("전자기학 개론", 6, professorKim));
        courseRepository.save(new Course("국제정치학", 6, professorLee));
        courseRepository.save(new Course("헌번론", 6, professorLee));
        courseRepository.save(new Course("사회복지학 개론", 6, professorChoi));

    }

}
