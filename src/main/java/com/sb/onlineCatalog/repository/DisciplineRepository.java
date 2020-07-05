package com.sb.onlineCatalog.repository;

import com.sb.onlineCatalog.model.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DisciplineRepository extends JpaRepository<Discipline,Integer> {
}
