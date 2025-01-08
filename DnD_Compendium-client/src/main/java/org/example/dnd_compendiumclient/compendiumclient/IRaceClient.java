package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.RaceDetailDto;

public interface IRaceClient {
    CompendiumEntryResultDto getRaces();
    CompendiumEntryResultDto getSubRaces();
    RaceDetailDto getRaceDetailByIndex(String index);
}
