package com.sb.onlineCatalog;

import com.sb.onlineCatalog.model.Student;
import com.sb.onlineCatalog.repository.StudentRepository;
//import com.sb.onlineCatalog.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineCatalogApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

   // @Autowired
  //  private SendGridEmailService sendGridEmailService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineCatalogApplication.class, args);
    }

    //done:  different sequence values for each table
    //TODO: discipline , grade + legaturile cu celelalte clase
    //TODO : display of the pages (CSS, HTML)
    //!TODO : only display year in school group , not the entire date. Only select year in date picker (edited)
    @Override
    public void run(String... args) throws Exception {
        //sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com"     ""   "buhaidebalta.15@gmail.com" );
//        Student student = new Student();
//        Student student2 = new Student();
//        student.setFirstName("John");
//        student.setLastName("Doe");
//        studentRepository.save(student);
//        student2.setFirstName("John1");
//        student2.setLastName("Doe1");
//        studentRepository.save(student2);
//        for (Student s : studentRepository.findAll()) {
//            System.out.println(s.getStudentId() + " " + s.getFirstName() + " " + s.getLastName());
//        }
//      //  studentRepository.delete(student2);
//        //studentRepository.findById(1);
    }
}
