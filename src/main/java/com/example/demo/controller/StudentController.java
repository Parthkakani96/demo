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
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

//  Get All Students
    @GetMapping("/student")
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//  Get Student by ID
    @GetMapping("/student/{studId}")
    private Student getStudent(@PathVariable("studId") long studId) {
        return studentService.getStudentByStudId(studId);
    }

//  Delete Student by ID
    @DeleteMapping("/student/{studId}")
    private void deleteStudent(@PathVariable("studId") long studId) {
        studentService.deleteStudent(studId);
    }

//  Create new Student
    @PostMapping("/signup/student")
    public Student createStudent(@Validated @RequestBody Student student){
        return studentRepository.save(student);
    }

//  Update Student with ID
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
