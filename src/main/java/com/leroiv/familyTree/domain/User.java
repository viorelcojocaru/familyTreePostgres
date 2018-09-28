package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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
    @Transient
    private String confirmPassword;
    @ManyToMany
    @JoinTable(name = "user_to_role" , joinColumns = @JoinColumn(name = "user_id"),
                                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
