package com.leroiv.familyTree.domain;

import javax.persistence.*;

@Entity(name = "familyTree")
@Table(name = "app_account_type")
public enum AppAccountType {
 MARRIED(10, "MARRIED"),
    ENGAGED(11, "ENGAGED"),
    RELATIONSHIP(12, "RELATIONSHIP"),
    SEPARATED(13, "SEPARATED"),
    DIVORCET(14, "DIVORCET"),
    ANULLED(15, "ANULLED");
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
