package com.sb.onlineCatalog.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class PendingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String activationCode;
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}

