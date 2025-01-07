package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
}
