package com.sb.onlineCatalog.controller;
import com.sb.onlineCatalog.model.Grade;
import com.sb.onlineCatalog.service.GradeService;
import com.sb.onlineCatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
       // model.addAttribute("schoolgroups", schoolGroupService.findAll());
        model.addAttribute("grade", new Grade()); // initial bind with the form, to say to the webpage
        // what is the type of student th:object

        return "grade/addgrade";
    }

    @PostMapping("/addgrade")
    public String addStudent(@ModelAttribute Grade grade) {
        gradeService.save(grade);
        return "redirect:/allgrades";

    }
//
//    @GetMapping("/editstudent/{id}")
//    public String editStudent(Model model, @PathVariable Integer id) {
//        model.addAttribute("schoolgroups", schoolGroupService.findAll());
//        Student student = studentService.findById(id);
//
//        model.addAttribute("student", student); // initial bind with the form, to say to the webpage
//
//        // what is the type of student th:object
//
//        return "student/editstudent";
//    }


}
