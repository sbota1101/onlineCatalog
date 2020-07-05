package com.sb.onlineCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") //pt a ne feri de incompatibilitati ca poate user e folosit
//TODO:make sure user is unique
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//start from 1 on each table
    private Integer userId;
    private String username;
    private String emailAddress;
    private String password;

    @ManyToOne(fetch=FetchType.LAZY)
    private Role role;
}
