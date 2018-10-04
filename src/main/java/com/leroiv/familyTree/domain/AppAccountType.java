package com.leroiv.familyTree.domain;

import javax.persistence.*;

@Entity(name = "familyTree")
@Table(name = "app_account_type")
public class AppAccountType {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    AppAccountType(int id, String name) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
