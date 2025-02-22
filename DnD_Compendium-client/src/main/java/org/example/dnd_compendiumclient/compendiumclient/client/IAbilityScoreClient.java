package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.AbilityScoreDetailsDto;

public interface IAbilityScoreClient {
    CompendiumEntryResultDto getAbilityScore();
    AbilityScoreDetailsDto getAbilityScoreDetails(String entityIndex);
}
