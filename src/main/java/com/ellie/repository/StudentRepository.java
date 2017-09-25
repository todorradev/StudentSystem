package com.ellie.repository;

import com.ellie.dto.MainDTO;
import com.ellie.entity.Grade;
import com.ellie.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);

    @Modifying
    @Query("update Student"
            + " set firstName = ?2,"
            + " lastName = ?3,"
            + " personal_data = ?4"
            + " where id = ?1")
    void update(Long id, String firstName, String lastName, String personalData);
}
