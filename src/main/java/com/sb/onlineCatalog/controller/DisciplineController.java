package com.sb.onlineCatalog.controller;

import com.sb.onlineCatalog.model.Discipline;
import com.sb.onlineCatalog.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DisciplineController {
@Autowired
    private DisciplineService disciplineService;
    @GetMapping("alldisciplines")
    public String showAllGrades(Model model) {

        List<Discipline> disciplines = disciplineService.findAll();
        model.addAttribute("disciplines", disciplines);

        return "discipline/alldisciplines";
    }

    @GetMapping("/adddiscipline")
    public String addDiscipline(Model model) {
        model.addAttribute("discipline", new Discipline());
        return "discipline/adddiscipline";
    }

    @PostMapping("/adddiscipline")
    public String addDiscipline(@ModelAttribute Discipline discipline) {
        disciplineService.save(discipline);
        return "redirect:/alldisciplines";

    }

    @GetMapping("/editdiscipline/{id}")
    public String editDiscipline(Model model, @PathVariable Integer id) {
        model.addAttribute("disciplines", disciplineService.findAll());
        Discipline discipline = disciplineService.findById(id);

        model.addAttribute("discipline", discipline); // initial bind with the form, to say to the webpage

        // what is the type of student th:object

        return "discipline/editdiscipline";
    }

    @PostMapping("/editdiscipline/{id}")
    public String editDiscipline(@ModelAttribute Discipline discipline, @PathVariable Integer id) {

        disciplineService.save(discipline); // save it again. SAVE acts as UPDATE

        return "redirect:/alldisciplines";

    }

    @GetMapping("/deletediscipline/{id}")
    public String deleteDiscipline(@PathVariable Integer id) {
        disciplineService.deleteById(id);

        return "redirect:/alldisciplines";
    }
    @GetMapping("/discipline/{id}/professors")
    public String viewProffessorsToDiscipline(Model model, @PathVariable Integer id) {
        model.addAttribute("professors", disciplineService.findProfessorsByDiscipline(id));
        return "discipline/viewprofessors";
    }


}
