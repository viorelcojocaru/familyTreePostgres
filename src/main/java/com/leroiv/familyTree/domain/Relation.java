package com.leroiv.familyTree.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor("a")
@Entity(name = "familyTree")
@Table(name = "relation")
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = AppAccount.class)
    @JoinColumn(name = "from_app_account_id", referencedColumnName = "id")
    private AppAccount fromAppAccountId;
    @ManyToOne(targetEntity = AppAccount.class)
    @JoinColumn(name = "to_app_account_id", referencedColumnName = "id")
    private AppAccount toAppAccountId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private String location;
}
