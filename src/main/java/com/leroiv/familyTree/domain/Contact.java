package com.leroiv.familyTree.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@Entity(name = "familyTree")
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String email;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "face_book")
    private String faceBook;
    private String blog;
    @Column(name = "photo_galery")
    private String photoGalery;
    private String skype;
    private String city;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
