package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class UserToPerson {
    @Id
//    @OneToOne(targetEntity = User.class)
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;
//    @OneToOne(targetEntity = Person.class)
    @Column(name = "person_id", unique = true, nullable = false)
    private long personId;
}
