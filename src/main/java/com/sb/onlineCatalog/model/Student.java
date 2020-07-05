package com.sb.onlineCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "YOUR_ENTITY_SEQ")
//    @SequenceGenerator(name = "YOUR_ENTITY_SEQ", sequenceName = "YOUR_ENTITY_SEQ", allocationSize = 1)

    private int studentId;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolGroup schoolGroup;

    @ManyToMany
    @JoinTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id"))
    private List<Grade> grades;

    @ManyToMany
    @JoinTable(name = "student_discipline", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

}

