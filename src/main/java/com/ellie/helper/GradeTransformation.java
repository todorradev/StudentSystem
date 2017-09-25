package com.ellie.helper;

import com.ellie.dto.GradeDTO;
import com.ellie.entity.Grade;

public class GradeTransformation {

    public static GradeDTO gradeToGradeDTO(Grade grade) {
        GradeDTO gradeDTo  = new GradeDTO();

        gradeDTo.setGrade(grade.getGrade());
        gradeDTo.setDiscipline(grade.getDiscipline());
        gradeDTo.setStudent(grade.getStudent());

        return gradeDTo;
    }

    public static Grade gradeDtoToGrade(GradeDTO gradeDTO) {
        Grade grade = new Grade();

        grade.setDiscipline(gradeDTO.getDiscipline());
        grade.setGrade(gradeDTO.getGrade());
        grade.setStudent(gradeDTO.getStudent());

        return grade;
    }
}
