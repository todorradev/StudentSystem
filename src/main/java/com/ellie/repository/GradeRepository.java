package com.ellie.repository;

import com.ellie.entity.Discipline;
import com.ellie.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO comment
 */
public interface GradeRepository extends JpaRepository<Grade, Long> {
    
}
