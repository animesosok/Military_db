package ru.nsu.db.militarys.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import ru.nsu.db.militarys.entity.MilitaryUnit;


public class MilitaryUnitService {
    @PersistenceContext
    EntityManager manager;
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory(" ru.nsu.db.militarys.service.MilitaryUnitService");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public Integer saveUnit(MilitaryUnit unit){
        manager = getEntityManager();
        manager.persist(unit);
        return unit.getUnitId();
    }
}
