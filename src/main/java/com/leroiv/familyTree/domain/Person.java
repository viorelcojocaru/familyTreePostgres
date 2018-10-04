package com.leroiv.familyTree.domain;

import com.leroiv.familyTree.constants.Genders;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "person", schema = "public")
public class Person implements Serializable {
    @Transient
    private final SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_name_on_birth")
    private String lastNameOnBirth;
    private int gender;

    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "in_alive")
    private boolean inALive = true;
    @Column(name = "death_date")
    private Date deathDate;
    @Column(name = "photo_path")
    private String photoPath;

/*    @Transient
    private Gender gender1;
    @Transient
    private List<Gender> genders;
    public List<Gender> getGenders(){
       return new ArrayList<Gender>(Arrays.asList(new Gender(10l,"male"), new Gender(20l,"female")));
    }
    @Builder
    @Data
    private static class Gender{
        Long id;
        String name;
    }*/
}
