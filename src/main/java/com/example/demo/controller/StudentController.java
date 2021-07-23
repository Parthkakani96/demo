package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentS    ervice studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//  creating a get mapping that retrieves the detail of a specific student

    @GetMapping("/student/{studId}")
    private Student getStudent(@PathVariable("studId") long studId) {
        return studentService.getStudentByStudId(studId);
    }

//  creating a delete mapping that deletes a specified student

    @DeleteMapping("/student/{studId}")
    private void deleteStudent(@PathVariable("studId") long studId) {
        studentService.deleteStudent(studId);
    }

//  creating new student

//    @PostMapping("/signup")
//    public ResponseEntity<?> saveStudent(@RequestBody Student student) throws Exception{
//
//        if (studentRepository.existsByRollNumber(student.getRollNumber())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Student already Register!!!"));
//        }
//        return ResponseEntity.ok(studentService.saveStudent(student));
//    }

//  creating put mapping that updates the student details

//    @PutMapping("/student/{studId}/update")
//    private Student updateStudent(@RequestBody Student student) {
//        studentService.updateStudent(student, student.getStudId());
//        return student;
//    }

//    From Here

    @PostMapping("/signup/student")
    public Student createStudent(@Validated @RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/student/update/{studId}")
    public Student studentUpdate(@PathVariable Long studId,
                                 @Validated @RequestBody Student studentUpdated){
        return studentRepository.findById(studId)
                .map(student -> {
                    student.setStudentName(studentUpdated.getStudentName());
                    student.setRollNumber(studentUpdated.getRollNumber());
                    student.setStudentGender(studentUpdated.getStudentGender());
                    student.setProjectName(studentUpdated.getProjectName());
                    student.setProjectTechnology(studentUpdated.getProjectTechnology());
                    student.setProjectStatus(studentUpdated.isProjectStatus());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new NotFoundException("Student not Found with id"+studId));}
    }
