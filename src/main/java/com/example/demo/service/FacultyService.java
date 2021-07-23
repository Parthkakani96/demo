package com.example.demo.service;

import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

        @Autowired
        private FacultyRepository facultyRepository;

    //  getting all faculty record by using the method findAll()
    public List<Faculty> getAllFaculties(){
        List<Faculty> faculties = new ArrayList<Faculty>();
        facultyRepository.findAll().forEach(faculty -> faculties.add(faculty));
        return faculties;
    }

    //  getting a specific record by using the method findById()
    public Faculty getFacultyById(long facultyId){
        return facultyRepository.findById((int) facultyId).get();
    }

    //  saving a specific record by using the method save()
    public Faculty saveFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    // deleting a specific record by using the method deleteById()
    public void deleteFaculty(long facultyId){
        facultyRepository.deleteById((int) facultyId);
    }

    //  updating a record
    public void updateFaculty(Faculty faculty, long facultyId){
        facultyRepository.save(faculty);
    }


}
