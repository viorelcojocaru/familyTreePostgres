package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_to_person")
public class UserToPerson {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;
    @Column(name = "person_id", unique = true, nullable = false)
    private long personId;
}
