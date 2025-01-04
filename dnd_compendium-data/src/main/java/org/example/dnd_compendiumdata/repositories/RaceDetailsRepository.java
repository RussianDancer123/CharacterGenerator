package org.example.dnd_compendiumdata.repositories;

import org.example.dnd_compendiumdata.model.RaceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceDetailsRepository extends JpaRepository<RaceDetails, Integer> {
}
