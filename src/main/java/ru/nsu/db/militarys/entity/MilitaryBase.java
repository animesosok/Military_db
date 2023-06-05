package ru.nsu.db.militarys.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "\"MILITARY_BASE\"", schema = "public")
public class MilitaryBase {

    @Id
    @Column(name = "\"UNIT_ID\"")
    private Integer unitId;

    @Column(name = "\"REGION_ID\"")
    private Integer regionId;


    public MilitaryBase() {
    }

    public MilitaryBase(Integer unitId, Integer regionId) {
        this.unitId = unitId;
        this.regionId = regionId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}