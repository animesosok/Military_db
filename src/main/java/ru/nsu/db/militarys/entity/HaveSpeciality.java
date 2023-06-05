package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"HAVE_SPECIALITY\"")
public class HaveSpeciality {
    @Id
    @OneToOne
    @JoinColumn(name = "\"PERSON_ID\"")
    private Person person;
    @Id
    @OneToOne
    @JoinColumn(name = "\"SPECIALITY_ID\"")
    private Speciality speciality;
    @Column(name = "\"GRADUATION_DATE\"")
    private String graduationDate;
}
