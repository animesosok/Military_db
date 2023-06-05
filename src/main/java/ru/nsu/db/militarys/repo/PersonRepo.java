package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nsu.db.militarys.entity.Person;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findAllByLastNameLike(String name);
    List<Person> findAllByLastNameStartingWithIgnoreCase(String name);

    List<Person> findAllByRank_isOfficerAndServeUnitId(boolean isOfficer, Integer unit);
    List<Person> findAllByRank_isOfficer(boolean isOfficer);
}
