package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.AbilityScore_Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityScore_ValueRepository extends JpaRepository<AbilityScore_Value, Integer> {
}
