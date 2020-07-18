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
//TODO:add @JsonIgnore la relatiile many to many ca sa nu ruleze la infinit
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Discipline discipline;

}