package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Alignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlignmentRepository extends JpaRepository<Alignment, Integer> {
    Alignment findByEntityIndex(String index);
}
