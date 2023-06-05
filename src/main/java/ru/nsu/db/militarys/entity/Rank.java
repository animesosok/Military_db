package ru.nsu.db.militarys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"RANK\"")
public class Rank {
    @Id
    @Column(name = "\"RANK_ID\"")
    private Integer rankId;
    @Column(name = "\"RANK_NAME\"")
    private String rankName;
    @Column(name = "\"IS_OFFICER\"")
    private boolean isOfficer;

    public Rank(){

    }
}
