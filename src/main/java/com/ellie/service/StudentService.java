package com.ellie.service;

import com.ellie.dto.DisciplineDTO;
import com.ellie.dto.GradeDTO;
import com.ellie.dto.MainDTO;
import com.ellie.dto.StudentDTO;
import com.ellie.entity.Discipline;
import com.ellie.entity.Grade;
import com.ellie.entity.Student;
import com.ellie.helper.DisciplineTransformation;
import com.ellie.helper.GradeTransformation;
import com.ellie.helper.StudentTransformation;
import com.ellie.repository.DisciplineRepository;
import com.ellie.repository.GradeRepository;
import com.ellie.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public void createStudent(StudentDTO studentDTO)
    {
        Student student = StudentTransformation.transformStudentDtoToStudent(studentDTO);

        try
        {
            studentRepository.save(student);
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    public List<StudentDTO> findAllStudents()
    {
        //        List<Student> students = studentRepository.findAll();
        //        List<Discipline> disciplines = disciplineRepository.findAll();
        //        List<Grade> grades = gradeRepository.findAll();
        //
        //        List<StudentDTO> studentDTOS = transformStudents(students);
        //        List<DisciplineDTO> disciplineDTOS = transformDisciplines(disciplines);
        //        List<GradeDTO> gradeDTOS = transformGrades(grades);
        //
        //        List<MainDTO> mainDTOS = new ArrayList<>();
        //
        //        for (int i = 0; i < studentDTOS.size(); i ++) {
        //            MainDTO mainDTO = new MainDTO();
        //
        //            mainDTO.setId(studentDTOS.get(i).getId());
        //            mainDTO.setFirstName(studentDTO.getFirstName());
        //            mainDTO.setLastName(studentDTO.getLastName());
        //            mainDTO.setPersonalData(studentDTO.getPersonalData());
        //            mainDTO.setSemester(studentDTO.getSemester());
        try
        {
            List<Grade> test = gradeRepository.findAll();
        }
        catch (Exception e)
        {
            String a = e.getMessage();
        }
        List<Student> students = studentRepository.findAll();

        List<StudentDTO> studentDTOS = new ArrayList();
        for (Student student : students)
        {
            studentDTOS.add(StudentTransformation.transformStudentToStudentDTO(student));
        }
        return studentDTOS;
    }

    public StudentDTO getStudent(Long id)
    {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent())
        {
            return null;
        }

        StudentDTO studentDTO = StudentTransformation.transformStudentToStudentDTO(student.get());
        return studentDTO;
    }

    public void deleteStudent(Long id)
    {
        studentRepository.delete(id);
    }

    private List<StudentDTO> transformStudents(List<Student> students)
    {
        List<StudentDTO> studentDTOS = new ArrayList();
        for (Student student : students)
        {
            studentDTOS.add(StudentTransformation.transformStudentToStudentDTO(student));
        }
        return studentDTOS;
    }

    private List<DisciplineDTO> transformDisciplines(List<Discipline> disciplines)
    {
        List<DisciplineDTO> disciplineDTOS = new ArrayList();
        for (Discipline discipline : disciplines)
        {
            disciplineDTOS.add(DisciplineTransformation.transformDisciplineToDisciplineDTO(discipline));
        }
        return disciplineDTOS;
    }

    private List<GradeDTO> transformGrades(List<Grade> grades)
    {
        List<GradeDTO> gradeDTOS = new ArrayList();
        for (Grade grade : grades)
        {
            gradeDTOS.add(GradeTransformation.gradeToGradeDTO(grade));
        }
        return gradeDTOS;
    }

    public void updateStudent(MainDTO mainDTO)
    {
        Student student = new Student();
        student.setId(mainDTO.getId());
        student.setFirstName(mainDTO.getFirstName());
        student.setLastName(mainDTO.getLastName());
        student.setPersonalData(mainDTO.getPersonalData());
        student.setSemester(mainDTO.getSemester());

        studentRepository.save(student);

        Discipline discipline = new Discipline();
        discipline.setDisciplineName(mainDTO.getDisciplineName());

        disciplineRepository.save(discipline);

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setDiscipline(discipline);
        grade.setGrade(mainDTO.getGrade());

        gradeRepository.save(grade);
    }

}
