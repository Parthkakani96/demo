package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Student  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studId;

    @Column
    private String studentName;

    @Column
    private int rollNumber;

    @Column
    private String studentGender;

    @Column
    private String projectName;

    @Column
    private String projectTechnology;

    @Column
    private boolean projectStatus;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Set<Faculty> faculty;

    public Student(){
    }

    public Student(String studentName, int rollNumber, String studentGender, String projectName, String projectTechnology, boolean projectStatus) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.studentGender = studentGender;
        this.projectName = projectName;
        this.projectTechnology = projectTechnology;
        this.projectStatus = projectStatus;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTechnology() {
        return projectTechnology;
    }

    public void setProjectTechnology(String projectTechnology) {
        this.projectTechnology = projectTechnology;
    }

    public boolean isProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(boolean projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Long getStudId() {
        return studId;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }

    public Set<Faculty> getFaculty() {
        return faculty;
    }

    public void setFaculty(Set<Faculty> faculty) {
        this.faculty = faculty;
    }
}
