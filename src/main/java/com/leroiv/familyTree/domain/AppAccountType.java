package com.leroiv.familyTree.domain;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "familyTree")
@Table(name = "app_account_type")
@RequiredArgsConstructor
public class AppAccountType {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
