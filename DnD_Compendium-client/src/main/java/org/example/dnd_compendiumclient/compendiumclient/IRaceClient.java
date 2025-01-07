package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SubRaceResultDto;

public interface IRaceClient {
    RaceResultDto getRaces();
    SubRaceResultDto getSubRaces();
    RaceDetailDto getRaceDetailByIndex(String index);
}
