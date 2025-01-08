package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.example.dnd_compendiumdata.model.SubRace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRaceRepository  extends JpaRepository<SubRace, Integer> {
}
