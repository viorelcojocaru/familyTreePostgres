package com.leroiv.familyTree.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@Entity
@Table
@ToString(exclude = {"country","person"})
@EqualsAndHashCode(exclude = {"country","person"})

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonBackReference
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

    @ManyToOne (cascade=CascadeType.ALL)
    @JsonManagedReference
    private Country country;

}
