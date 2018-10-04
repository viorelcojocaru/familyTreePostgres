package com.leroiv.familyTree.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "role", schema = "public")
@NoArgsConstructor
public class Role implements Serializable {

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(long id) {
        this.id = id;
        this.name = "USER";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;
    private String name;

}
