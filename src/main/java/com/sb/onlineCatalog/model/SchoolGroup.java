package com.sb.onlineCatalog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SchoolGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;
    private String groupName;
    private Date groupYear;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private List<Discipline> disciplines;
    @OneToMany(
            mappedBy = "schoolGroup",
            cascade = CascadeType.ALL
    )
    private List<Student> students;


}