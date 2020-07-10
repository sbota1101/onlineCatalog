package com.sb.onlineCatalog.controller;

import com.sb.onlineCatalog.model.Grade;
import com.sb.onlineCatalog.service.GradeService;
import com.sb.onlineCatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GradeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;

    @GetMapping("allgrades")
    public String showAllGrades(Model model) {

        List<Grade> grades = gradeService.findAll();
        model.addAttribute("grades", grades);

        return "grade/showallgrades";
    }

    @GetMapping("/addgrade")
    public String addGrade(Model model) {
        model.addAttribute("grade", new Grade());
        return "grade/addgrade";
    }

    @PostMapping("/addgrade")
    public String addGrade(@ModelAttribute Grade grade) {
        gradeService.save(grade);
        return "redirect:/allgrades";

    }

    @GetMapping("/editgrade/{id}")
    public String editGrade(Model model, @PathVariable Integer id) {
        model.addAttribute("grades", gradeService.findAll());
        Grade grade = gradeService.findById(id);

        model.addAttribute("grade", grade); // initial bind with the form, to say to the webpage

        // what is the type of student th:object

        return "grade/editgrade";
    }

    @PostMapping("/editgrade/{id}")
    public String editGrade(@ModelAttribute Grade grade, @PathVariable Integer id) {

        gradeService.save(grade); // save it again. SAVE acts as UPDATE

        return "redirect:/allgrades";

    }

    @GetMapping("/deletegrade/{id}")
    public String deleteGrade(@PathVariable Integer id) {
        gradeService.deleteById(id);

        return "redirect:/allgrades";
    }

}
