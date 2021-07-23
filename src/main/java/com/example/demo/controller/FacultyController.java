package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/faculties")

    private List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculties();
    }







    //  creating a get mapping that retrieves the detail of a specific faculty

    @GetMapping("/faculty/{facultyId}")
    private Faculty getFaculty(@PathVariable("facultyId") int facultyId){
        return facultyService.getFacultyById(facultyId);
    }


    @GetMapping("/students/{studId}/faculty")
    public List getContactByStudentId(@PathVariable Long studId){

        if (!studentRepository.existsById(studId)){
            throw new NotFoundException("Student not Found");
        }
        return facultyRepository.findByStudentStudId(studId);
    }

    @PutMapping("/students/{studId}/faculty/{facultyId}")
    public Faculty facultyUpdate(@PathVariable Long studId,
                                 @PathVariable int facultyId,
                                 @Validated @RequestBody Faculty facultyUpdated){
        if ((!studentRepository.existsById(studId))){
            throw new NotFoundException("Student Not Found");
        }
        return facultyRepository.findById(facultyId)
                .map(faculty -> {
                    faculty.setFacultyId(facultyUpdated.getFacultyId());
                    faculty.setFacultyName(facultyUpdated.getFacultyName());
                    faculty.setFacultyGender(facultyUpdated.getFacultyGender());
                    faculty.setSubjectTakenByFaculty(facultyUpdated.getSubjectTakenByFaculty());
                    return facultyRepository.save(faculty);
                }).orElseThrow(() -> new NotFoundException("Faculty not Found"));
    }

    @PostMapping("/student/{studId}/faculty")
    public Faculty addFaculty(@PathVariable Long studId,
                              @Validated @RequestBody Faculty faculty){
        return studentRepository.findById(studId)
                .map(student -> {
                    faculty.setStudent(student);
                    return facultyRepository.save(faculty);
                }).orElseThrow(() -> new NotFoundException("Student Not Found"));
    }


}
