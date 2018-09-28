package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_to_role")
public class UserToRole {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;
    @Column(name = "role_id", unique = true, nullable = false)
    private long roleId;
}
