package com.leroiv.familyTree.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "person")
public class Person {
    @Transient
    private final SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private long id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "last_name_on_birth")
    private String lastNameOnBirth;
    private int gender;
    @NonNull
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "in_alive")
    private boolean inALive = true;
    @Column(name = "death_date")
    private Date deathDate;
    @Column(name = "photo_path")
    private String photoPath;

    public Person(String firstName, String lastName, int gender, String birthDate) throws ParseException {
        this.id = new Long(0);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = simpleDateformat.parse(birthDate);
    }

}
