package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true )
    private long id;
    private String login;
    private String password;
}
