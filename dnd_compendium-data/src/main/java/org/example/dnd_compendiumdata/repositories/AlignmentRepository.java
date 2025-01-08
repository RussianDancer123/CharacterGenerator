package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlignmentRepository extends JpaRepository<Alignment, Integer> {
}
