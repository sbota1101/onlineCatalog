package com.sb.onlineCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disciplineId;

    private String disciplineName;
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<Professor> professors;
    @ManyToMany(mappedBy = "disciplines")
    private List<Student> students;
    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolGroup schoolGroup;
}
