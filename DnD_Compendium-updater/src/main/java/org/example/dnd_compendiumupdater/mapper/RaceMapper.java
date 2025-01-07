package org.example.dnd_compendiumupdater.mapper;

import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDto;
import org.example.dnd_compendiumdata.model.Race;
import org.example.dnd_compendiumdata.model.RaceDetails;
import org.springframework.stereotype.Component;

@Component
public class RaceMapper {

    public Race toRace(RaceDto raceDto) {
        Race race = new Race();
        race.setEntityIndex(raceDto.index());
        race.setName(raceDto.name());
        race.setUrl(raceDto.url());
        return race;
    }

    public RaceDetails toRaceDetails(RaceDetailDto raceDetailDto) {
        RaceDetails raceDetails = new RaceDetails();
        raceDetails.setEntityIndex(raceDetailDto.index());
        raceDetails.setName(raceDetailDto.name());
        raceDetails.setSpeed(raceDetailDto.speed());
        return raceDetails;
    }
}
