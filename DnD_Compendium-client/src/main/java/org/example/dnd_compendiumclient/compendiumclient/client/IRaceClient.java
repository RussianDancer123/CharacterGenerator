package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;

public interface IRaceClient {
    CompendiumEntryResultDto getRaces();
    CompendiumEntryResultDto getSubRaces();
    RaceDetailDto getRaceDetailByIndex(String index);
}
