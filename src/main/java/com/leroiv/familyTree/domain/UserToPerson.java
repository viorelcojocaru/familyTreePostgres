package com.leroiv.familyTree.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_to_person", schema="public")
@AllArgsConstructor
public class UserToPerson implements Serializable {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;
    @Column(name = "person_id", unique = true, nullable = false)
    private long personId;
}
