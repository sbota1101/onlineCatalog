package com.sb.onlineCatalog.controller.rest;

import com.sb.onlineCatalog.model.Student;
import com.sb.onlineCatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        return ResponseEntity.of(studentRepository.findById(id));
    }
}
