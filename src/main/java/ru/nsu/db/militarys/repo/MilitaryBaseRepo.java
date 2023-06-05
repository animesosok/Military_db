package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.db.militarys.entity.MilitaryBase;

import java.util.List;
public interface MilitaryBaseRepo extends JpaRepository<MilitaryBase, Long> {

}
