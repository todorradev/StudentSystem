package com.ellie.dto;


import com.ellie.entity.Student;

import javax.validation.constraints.Size;

public class DisciplineDTO {
    private Long id;

    @Size(max = 50)
    private String disciplineName;

    @Size(max = 50)
    private Integer semester;

    @Size(max = 50)
    private Integer grade;

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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
