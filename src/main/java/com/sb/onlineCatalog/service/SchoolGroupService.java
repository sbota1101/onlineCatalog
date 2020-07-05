package com.sb.onlineCatalog.service;

import com.sb.onlineCatalog.model.SchoolGroup;
import com.sb.onlineCatalog.model.Student;
import com.sb.onlineCatalog.repository.SchoolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISchoolGroupService")
public class SchoolGroupService {

    @Autowired
    private SchoolGroupRepository schoolGroupRepository;


    public List<SchoolGroup> findAll() {
        return schoolGroupRepository.findAll();
    }

    public void save(SchoolGroup schoolGroup) {
        schoolGroupRepository.save(schoolGroup);
    }
    public SchoolGroup findById(Integer id) {
        Optional<SchoolGroup> schoolGroup = schoolGroupRepository.findById(id);
        if (schoolGroup.isPresent()) {
            return schoolGroup.get();
        }

        return null;
    }

    public List<Student> findStudentsByGroup(Integer id) {
        //done: try catch / check if present
        Optional<SchoolGroup> students =  schoolGroupRepository.findById(id);
        if (students.isPresent()) {
            return students.get().getStudents();
        }
        return null;
    }
    public void deleteById(Integer id) {
        schoolGroupRepository.deleteById(id);
    }

 }

