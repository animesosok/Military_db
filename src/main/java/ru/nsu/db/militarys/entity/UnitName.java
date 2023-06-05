package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "\"UNIT_NAMES\"")
public class UnitName {

    @Id
    @Column(name = "\"UNIT_NAME_ID\"")
    private Integer unitNameId;

    @Column(name = "\"UNIT_NAME\"")
    private String unitName;

    @Column(name = "\"RANK\"")
    private Integer rank;


    public UnitName() {
    }

}