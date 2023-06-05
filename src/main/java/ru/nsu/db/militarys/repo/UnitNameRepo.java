package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.db.militarys.entity.UnitName;

public interface UnitNameRepo extends JpaRepository<UnitName, Long> {
}
