package org.example.dnd_compendiumdata.repositories;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AllRepositories {
    private final RaceDetailsRepository raceDetailsRepository;
    private final RaceRepository raceRepository;

    public AllRepositories(RaceDetailsRepository raceDetailsRepository, RaceRepository raceRepository) {
        this.raceDetailsRepository = raceDetailsRepository;
        this.raceRepository = raceRepository;
    }
}
