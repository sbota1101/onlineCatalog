package com.sb.onlineCatalog.service;

import com.sb.onlineCatalog.model.Professor;
import com.sb.onlineCatalog.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IProfessorService")
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    public Professor findById(Integer id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return professor.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}
