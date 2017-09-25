package com.ellie.helper;

import com.ellie.dto.StudentDTO;
import com.ellie.entity.Student;

public class StudentTransformation {

    /**
     * Convert student entity to studentDTO
     *
     * @param student - which will be transform
     * @return studentDTO
     */
    public static StudentDTO transformStudentToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setPersonalData(student.getPersonalData());
        studentDTO.setSemester(student.getSemester());

        return studentDTO;
    }

    /**
     * Convert studentDTO to student entity
     *
     * @param studentDTO - which will be transform
     * @return student
     */
    public static Student transformStudentDtoToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPersonalData(studentDTO.getPersonalData());
        student.setSemester(studentDTO.getSemester());
        return student;
    }
}
