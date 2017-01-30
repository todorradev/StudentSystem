package com.ellie.service;

import com.ellie.dto.StudentDTO;
import com.ellie.entity.Student;
import com.ellie.helper.StudentTransformation;
import com.ellie.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(StudentDTO studentDTO) {
        Student student = StudentTransformation.transformStudentDtoToStudent(studentDTO);
        studentRepository.save(student);
    }

    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTO = new ArrayList<>();
        for (Student student : students) {
            studentDTO.add(StudentTransformation.transformStudentToStudentDTO(student));
        }

        return studentDTO;
    }

    public StudentDTO getStudent(Long id) {
        Student student = studentRepository.findOne(id);
        if (student == null)
            return null;

        StudentDTO studentDTO = StudentTransformation.transformStudentToStudentDTO(student);
        return studentDTO;
    }

    public void updateStudent(StudentDTO studentDTO) {
        Student student = StudentTransformation.transformStudentDtoToStudent(studentDTO);
        studentRepository.update(student.getId(), student.getFirstName(), student.getLastName(), student.getPersonalData());
    }
}
