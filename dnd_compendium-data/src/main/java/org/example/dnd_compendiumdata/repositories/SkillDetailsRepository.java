package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.SkillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDetailsRepository extends JpaRepository<SkillDetails, Integer> {
    SkillDetails findByEntityIndex(String index);
}
