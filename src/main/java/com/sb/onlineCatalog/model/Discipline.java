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
    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "YOUR_ENTITY_SEQ")
//    @SequenceGenerator(name = "YOUR_ENTITY_SEQ", sequenceName = "YOUR_ENTITY_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String disciplineName;
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<Professor> professors;
    @ManyToMany(mappedBy = "disciplines")
    private List<Student> students;
    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolGroup schoolGroup;
}
