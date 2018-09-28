package com.leroiv.familyTree.domain;

import javax.persistence.*;

@Entity(name = "familyTree")
@Table(name = "app_account_type")
public class AppAccountType {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true )
    private int id;

    AppAccountType(int id, String name) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
