package com.sb.onlineCatalog.service;

import com.sb.onlineCatalog.model.Grade;
import com.sb.onlineCatalog.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("IGradeService")
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public void save(Grade grade) {
        gradeRepository.save(grade);
    }
}
