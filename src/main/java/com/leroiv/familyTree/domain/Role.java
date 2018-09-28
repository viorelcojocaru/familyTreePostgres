package com.leroiv.familyTree.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "role")
public class Role {

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "role")
    private Set<User> users;

}
