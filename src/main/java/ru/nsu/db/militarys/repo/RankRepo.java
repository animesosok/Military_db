package ru.nsu.db.militarys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.db.militarys.entity.Rank;

public interface RankRepo extends JpaRepository<Rank, Long> {
}
