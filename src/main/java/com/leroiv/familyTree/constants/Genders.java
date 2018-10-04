package com.leroiv.familyTree.constants;

public enum Genders {
    FEMALE(20,"female"),
    MALE(10,"male");

    private final String name;
    private final int id;
    Genders(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
