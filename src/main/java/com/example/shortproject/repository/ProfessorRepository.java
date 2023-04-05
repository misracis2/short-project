package com.example.shortproject.repository;

import com.example.shortproject.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {


    Optional<Professor> findByName(String name);


    Optional<Professor> findByLoginId(String loginId);
}
