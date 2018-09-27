package com.leroiv.familyTree.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity(name = "familyTree")
@Table(name = "app_Account")
public class AppAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true )
    private long id;
    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_Id", referencedColumnName = "id" )

    private Person personId;
    @ManyToOne(targetEntity = AppAccountType.class)
    @JoinColumn(name = "type_Id", referencedColumnName = "id")
    private AppAccountType typeId;

    private String name;
}
