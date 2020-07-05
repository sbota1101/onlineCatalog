package com.sb.onlineCatalog.repository;

import com.sb.onlineCatalog.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
