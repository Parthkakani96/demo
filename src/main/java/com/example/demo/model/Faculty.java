package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private int facultyId;

    @Column
    private String facultyName;

    @Column
    private String facultyGender;

    @Column
    private String subjectTakenByFaculty;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stud_id", nullable = false)

    private Student student;


    public Faculty(){
    }

//    public Faculty(String facultyName, String facultyGender, String subjectTakenByFaculty) {
//        this.facultyName = facultyName;
//        this.facultyGender = facultyGender;
//        this.subjectTakenByFaculty = subjectTakenByFaculty;
//    }


//    public Faculty(int facultyId, String facultyName, String facultyGender, String subjectTakenByFaculty, Student student) {
//        this.facultyId = facultyId;
//        this.facultyName = facultyName;
//        this.facultyGender = facultyGender;
//        this.subjectTakenByFaculty = subjectTakenByFaculty;
//        this.student = student;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyGender() {
        return facultyGender;
    }

    public void setFacultyGender(String facultyGender) {
        this.facultyGender = facultyGender;
    }

    public String getSubjectTakenByFaculty() {
        return subjectTakenByFaculty;
    }

    public void setSubjectTakenByFaculty(String subjectTakenByFaculty) {
        this.subjectTakenByFaculty = subjectTakenByFaculty;
    }

}
