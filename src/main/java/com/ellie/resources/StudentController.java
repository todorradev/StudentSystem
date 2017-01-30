package com.ellie.resources;

import com.ellie.dto.StudentDTO;
import com.ellie.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        if (studentService.getStudent(studentDTO.getId()) != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        studentService.createStudent(studentDTO);
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<?> getAllStudents() {
        try {
            return new ResponseEntity<List<StudentDTO>>(studentService.findAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudent(id);
        if (studentDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<StudentDTO>(studentService.getStudent(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/students", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO) {
        try {
            studentService.updateStudent(studentDTO);
            return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
