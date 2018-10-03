package com.leroiv.familyTree.domain;

import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.service.RoleService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name = "role", schema = "public")
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
