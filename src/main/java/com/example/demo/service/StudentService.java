package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

//  getting all student record by using the method findAll()

    public List<Student> getAllStudents(){
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> student.add(student1));
        return student;
    }

//  getting a specific record by using the method findById()

    public Student  getStudentByStudId(long studId){
        return studentRepository.findById(studId).get();
    }

//  saving a specific record by using the method save()

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

//  deleting a specific record by using the method deleteById()

    public void deleteStudent(long studId){
        studentRepository.deleteById(studId);
    }

//  updating a record

    public void updateStudent(Student student, long studId){
        studentRepository.save(student);
    }
}
