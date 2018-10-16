package com.leroiv.familyTree.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "app_account")//can be done in configuration file _
public class AppAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_Id", referencedColumnName = "id")
    private Person personId;

    @ManyToOne(targetEntity = AppAccountType.class)
    @JoinColumn(name = "type_Id", referencedColumnName = "id")
    private AppAccountType typeId;

    private String name;
}
