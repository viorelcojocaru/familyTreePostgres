package com.leroiv.familyTree.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user" , schema = "public")
//@Builder
public class User implements Serializable {
    public User(){

    }
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

    @OneToOne
    @JoinTable(name = "person_to_user",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
            }
    )
    private Person loggedPerson;

    public Person getLoggedPerson() {
        return loggedPerson;
    }

    public void setLoggedPerson(Person loggedPerson) {
        this.loggedPerson = loggedPerson;
    }

    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }
    }

    public void removeRole(Role role){
        this.roles.remove(role);
    }
}
