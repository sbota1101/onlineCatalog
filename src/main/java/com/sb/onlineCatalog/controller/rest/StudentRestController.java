package com.sb.onlineCatalog.controller.rest;

import com.sb.onlineCatalog.model.Student;
import com.sb.onlineCatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    @PatchMapping("/student/edit")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
