package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.example.dnd_compendiumdata.model.SpellDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellDetailsRepository  extends JpaRepository<SpellDetails, Integer> {
    SpellDetails findByEntityIndex(String entityIndex);
}
