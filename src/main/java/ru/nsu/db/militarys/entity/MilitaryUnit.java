package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "\"MILITARY_UNIT\"")
public class MilitaryUnit  {

    @Id
    //@SequenceGenerator(name = "unit_seq", sequenceName = "unit_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"UNIT_ID\"")
    private Integer unitId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"UNIT_NAME_ID\"")
    private UnitName unitName;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="\"COMMANDER_ID\"")
    private Person commander;

    @Column(name = "\"PARENT_UNIT\"")
    private Integer parentUnit;



}
