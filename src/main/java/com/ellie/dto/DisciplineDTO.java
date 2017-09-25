package com.ellie.dto;


import com.ellie.entity.Student;

import javax.validation.constraints.Size;

public class DisciplineDTO {
    private Long id;

    @Size(max = 50)
    private String disciplineName;

    @Size(max = 50)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
