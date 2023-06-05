package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.db.militarys.entity.Speciality;

public interface SpecialityRepo extends JpaRepository<Speciality, Long> {
}
