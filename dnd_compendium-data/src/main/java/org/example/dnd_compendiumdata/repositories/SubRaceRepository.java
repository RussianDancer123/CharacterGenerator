package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.SubRace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRaceRepository  extends JpaRepository<SubRace, Integer> {
    SubRace findByEntityIndex(String index);
}
