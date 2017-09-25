package com.ellie.dto;

import com.ellie.entity.Discipline;
import com.ellie.entity.Student;

public class GradeDTO {
    private Student student;

    private Discipline discipline;

    private Integer grade;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
