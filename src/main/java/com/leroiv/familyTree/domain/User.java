package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user" , schema = "public")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true )
    private long id;
    @Column(name = "user_name")
    private String userName;

    private String password;
    @Transient
    private String confirmPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_to_role" ,
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();;
    @Transient
    private String encryptedPassword;
    @Transient
    private Integer failedLoginAttempts = 0;

    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }
    }

    public void removeRole(Role role){
        this.roles.remove(role);
    }

    /*@OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "person_to_user" ,
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Person> persons = new HashSet<>();*/
}
