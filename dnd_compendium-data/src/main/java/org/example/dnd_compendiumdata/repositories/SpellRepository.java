package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.example.dnd_compendiumdata.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository  extends JpaRepository<Spell, Integer> {
}
