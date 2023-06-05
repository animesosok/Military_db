package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"PERSON\"")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"PERSON_ID\"")
    private Integer personId;

    @Column(name = "\"LAST_NAME\"")
    private String lastName;

    @Column(name = "\"FIRST_NAME\"")
    private String firstName;

    @Column(name = "\"FATHER_NAME\"")
    private String fatherName;

    @Column(name = "\"BIRTHDAY\"")
    private String birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"RANK_ID\"")
    private Rank rank;

    @Column(name = "\"SERVE_UNIT_ID\"")
    private Integer serveUnitId;

    public Person() {
    }


}
