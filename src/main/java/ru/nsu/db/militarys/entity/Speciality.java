package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"SPECIALITY\"")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"SPECIALITY_ID\"")
    private Integer specialityId;

    @Column(name = "\"SPECIALITY_NAME\"")
    private String specialityName;

    public Speciality(){

    }
}
