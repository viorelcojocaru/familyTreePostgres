package com.leroiv.familyTree.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
public class ContactDto {

    private Long id;

    private Long personId;

    private String email;

    private String webSite;

    private String faceBook;

    private String blog;

    private String photoGalery;

    private String skype;

    private String city;

    private Long countryId;

}
