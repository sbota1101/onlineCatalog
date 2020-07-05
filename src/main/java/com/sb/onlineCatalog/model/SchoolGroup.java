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
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "YOUR_ENTITY_SEQ")
//    @SequenceGenerator(name = "YOUR_ENTITY_SEQ", sequenceName = "YOUR_ENTITY_SEQ", allocationSize = 1)
    private int groupId;
    private String groupName;
    private Date groupYear;

    @OneToMany(
            mappedBy = "schoolGroup",
            cascade = CascadeType.ALL
    )
    private List<Student> students;

}