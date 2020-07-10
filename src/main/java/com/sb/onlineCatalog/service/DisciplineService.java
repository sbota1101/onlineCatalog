package com.sb.onlineCatalog.service;

import com.sb.onlineCatalog.model.Discipline;
import com.sb.onlineCatalog.model.Professor;
import com.sb.onlineCatalog.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IDisciplineService")
public class DisciplineService {


    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    public void save(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public Discipline findById(Integer id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        if (discipline.isPresent()) {
            return discipline.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        disciplineRepository.deleteById(id);
    }



    public List<Professor> findProfessorsByDiscipline(Integer id) {
        Optional<Discipline> professors = disciplineRepository.findById(id);
        if (professors.isPresent()) {
            return professors.get().getProfessors();
        }
        return null;
    }
}
