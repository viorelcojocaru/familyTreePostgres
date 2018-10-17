package com.leroiv.familyTree.domain;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "app_account")
@Builder
public class AppAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_Id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(targetEntity = AppAccountType.class)
    @JoinColumn(name = "type_Id", referencedColumnName = "id")
    private AppAccountType type;

    private String name;
}
