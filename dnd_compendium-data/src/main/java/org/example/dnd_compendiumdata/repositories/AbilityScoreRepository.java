package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.AbilityScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityScoreRepository extends JpaRepository<AbilityScore, Integer> {
}
