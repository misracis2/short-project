package com.example.shortproject.repository;

import com.example.shortproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //동시 수강신청 처리를 위한 비관적 락 설정
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<Course> findById(Long aLong);
}
