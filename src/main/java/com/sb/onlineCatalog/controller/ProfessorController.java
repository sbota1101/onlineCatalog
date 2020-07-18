package com.sb.onlineCatalog.controller;

import com.sb.onlineCatalog.model.Professor;
import com.sb.onlineCatalog.service.DisciplineService;
import com.sb.onlineCatalog.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("allprofessors")
    public String showAllProfessors(Model model) {
        List<Professor> professorList = professorService.findAll();
        model.addAttribute("professors", professorList);
        return "professor/showallprofessors";
    }


    @GetMapping("/addprofessor")
    public String addprofessor(Model model) {
        model.addAttribute("disciplines",disciplineService.findAll());
        model.addAttribute("professor", new Professor());//initial bind with the form,to say to the webpage

        return "professor/addprofessor";
    }

    @PostMapping("/addprofessor")
    public String addprofessor(@ModelAttribute Professor professor) {

        professorService.save(professor);
        return "redirect:/allprofessors";

    }

    @GetMapping("/editprofessor/{id}")
    public String editprofesor(Model model, @PathVariable Integer id) {
        Professor professor = professorService.findById(id);
        model.addAttribute("disciplines",disciplineService.findAll());
        model.addAttribute("professor", professor); // initial bind with the form, to say to the webpage
        // what is the type of student th:object

        return "professor/editprofessor";
    }

    @PostMapping("/editprofessor/{id}")
    public String editProfessor(@ModelAttribute Professor professor, @PathVariable Integer id) {

        professorService.save(professor); // save it again. SAVE acts as UPDATE

        return "redirect:/allprofessors";

    }

    @GetMapping("/deleteprofessor/{id}")
    public String deleteprofessor(@PathVariable Integer id) {

        professorService.deleteById(id);
        return "redirect:/allprofessors";
    }
}