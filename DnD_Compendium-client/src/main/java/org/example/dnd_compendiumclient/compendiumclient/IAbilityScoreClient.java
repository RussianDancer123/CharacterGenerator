package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.details.AbilityScoreDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;

public interface IAbilityScoreClient {
    CompendiumEntryResultDto getAbilityScore();
    AbilityScoreDetailDto getAbilityScoreDetail(String index);
}
