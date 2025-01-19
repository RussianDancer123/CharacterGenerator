package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
