package com.sb.onlineCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "YOUR_ENTITY_SEQ")
//    @SequenceGenerator(name = "YOUR_ENTITY_SEQ", sequenceName = "YOUR_ENTITY_SEQ", allocationSize = 1)
    private int professorId;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Discipline discipline;

}