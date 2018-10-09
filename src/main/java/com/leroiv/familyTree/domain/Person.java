package com.leroiv.familyTree.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
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
    private int gender=30;

    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "in_alive")
    private boolean inALive;
    @Column(name = "death_date")
    private Date deathDate;
    @Column(name = "photo_path")
    private String photoPath;

    @ToString.Exclude
    @OneToOne(mappedBy="person" )
    private Contact contact;

   @Transient
    private Gender currentGender;

    public Gender getCurrentGender() {
        return  getGenders().stream()
                .filter(one->one.id.intValue()==getGender())
                .findAny().orElse(null);
    }

    public void setCurrentGender(Gender currentGender) {
        this.gender=currentGender.getId().intValue();
        this.currentGender = currentGender;
    }

    @Transient
    private List<Gender> genders ;

    public List<Gender> getGenders(){
       return new ArrayList<Gender>(Arrays.asList(new Gender(10l,"Male"), new Gender(20l,"Female"), new Gender(30l,"Undefined")));
    }
    @Builder
    @Data
    public static class Gender{
        Long id;
        String name;
    }

}
