package com.leroiv.familyTree.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table
public class UserToPerson {
private long user_id;
private long person_id;
}
