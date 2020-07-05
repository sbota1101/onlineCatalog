package com.sb.onlineCatalog.repository;

import com.sb.onlineCatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
