package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.example.dnd_compendiumdata.model.SpellDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellDetailsRepository  extends JpaRepository<SpellDetails, Integer> {
}
