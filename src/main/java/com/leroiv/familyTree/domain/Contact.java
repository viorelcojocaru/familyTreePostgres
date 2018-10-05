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

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personId;
    @Email
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
    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    private String other;

}
