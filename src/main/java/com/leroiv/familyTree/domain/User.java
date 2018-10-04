package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;

    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_to_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Transient
    private String encryptedPassword;
    @Transient
    private Integer failedLoginAttempts = 0;

    @OneToOne
    @JoinTable(name = "person_to_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Person userToPerson = new Person();

    public void addRole(Role role) {
        if (!this.roles.contains(role)) {
            this.roles.add(role);
        }
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }
}
