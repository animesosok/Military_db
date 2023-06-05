package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.db.militarys.entity.MilitaryUnit;

import java.util.List;


public interface MilitaryUnitRepo extends JpaRepository<MilitaryUnit, Long> {
}
