package org.example.dnd_compendiumupdater.updater;

import jakarta.transaction.Transactional;
import org.example.dnd_compendiumclient.compendiumclient.CompendiumClient;
import org.example.dnd_compendiumclient.compendiumclient.ICompendiumClient;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumdata.model.Race;
import org.example.dnd_compendiumdata.model.RaceDetails;
import org.example.dnd_compendiumdata.repositories.AllRepositories;
import org.example.dnd_compendiumdata.repositories.RaceDetailsRepository;
import org.example.dnd_compendiumdata.repositories.RaceRepository;
import org.example.dnd_compendiumupdater.mapper.RaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompendiumUpdater implements ICompendiumUpdater {

    private final ICompendiumClient compendiumClient;
    private final AllRepositories allRepositories;
    private final RaceMapper raceMapper;

    public CompendiumUpdater(ICompendiumClient compendiumClient, RaceMapper raceMapper, AllRepositories allRepositories){
        this.compendiumClient = compendiumClient;
        this.allRepositories = allRepositories;
        this.raceMapper = raceMapper;
    }

    @Override
    public void updateCompendium() {
        allRepositories.getRaceRepository().deleteAll();
        allRepositories.getRaceDetailsRepository().deleteAll();

        List<RaceDto> raceDto = compendiumClient.getRaceClient().getRaces().results();
        List<Race> races = raceDto.stream().map(raceMapper::toRace).toList();
        races.forEach(this::updateRaceDetails);
        allRepositories.getRaceRepository().saveAll(races);
    }

    private void updateRaceDetails(Race race) {
        RaceDetailDto raceDetailDto = compendiumClient.getRaceClient().getRaceDetailByIndex(race.getEntityIndex());
        RaceDetails raceDetails = raceMapper.toRaceDetails(raceDetailDto);
        race.setRaceDetails(raceDetails);
        allRepositories.getRaceDetailsRepository().save(raceDetails);
    }
}
