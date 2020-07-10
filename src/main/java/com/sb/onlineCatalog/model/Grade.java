package com.sb.onlineCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Grade {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;
    private double grade;
    private Date gradeDate;
    @ManyToMany(mappedBy = "grades", cascade = CascadeType.ALL)
    private List<Student> studentList;

}
