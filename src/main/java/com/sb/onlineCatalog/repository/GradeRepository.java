package com.sb.onlineCatalog.repository;

import com.sb.onlineCatalog.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeRepository extends JpaRepository<Grade,Integer> {
}
